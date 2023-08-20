package com.benidict.network.remotesource.teams

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.benidict.domain.model.Team
import com.benidict.network.NbaServiceApi
import com.benidict.network.remotesource.teams.paging.TeamPagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamRemoteSourceImpl @Inject constructor(
    private val nbaServiceApi: NbaServiceApi
) {

    companion object {
        const val PAGE_SIZE = 10
    }

    fun loadTeams(): Flow<PagingData<Team>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE
        ),
        pagingSourceFactory = {
            TeamPagingDataSource(
                nbaServiceApi = nbaServiceApi
            )
        }
    ).flow
}