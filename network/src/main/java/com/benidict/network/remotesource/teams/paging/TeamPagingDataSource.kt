package com.benidict.network.remotesource.teams.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.benidict.domain.model.Team
import com.benidict.network.NbaServiceApi
import com.benidict.network.model.TeamDTO.Companion.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TeamPagingDataSource(
 private val nbaServiceApi: NbaServiceApi
): PagingSource<Int, Team>(){
    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Team> {
        val page = params.key ?: STARTING_PAGE_INDEX
       return try {
           withContext(Dispatchers.IO) {
               val response = nbaServiceApi.loadTeams(
                   page = page,
                   perPage = params.loadSize
               ).data.toDomain()
               LoadResult.Page(
                   data = response,
                   prevKey = if (page == STARTING_PAGE_INDEX) null else page.minus(1),
                   nextKey = if (response.isEmpty()) null else page.plus(1)
               )
           }
       } catch (e: Exception) {
           return LoadResult.Error(e)
       }
    }

    override fun getRefreshKey(state: PagingState<Int, Team>): Int? =
        state.anchorPosition?.let { position ->
            state.closestPageToPosition(position)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(position)?.nextKey?.minus(1)
        }
}