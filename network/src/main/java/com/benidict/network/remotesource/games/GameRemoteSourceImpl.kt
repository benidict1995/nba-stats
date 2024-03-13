package com.benidict.network.remotesource.games

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.benidict.domain.model.Game
import com.benidict.network.API_KEY
import com.benidict.network.NbaServiceApi
import com.benidict.network.model.GameDTO.Companion.toDomain
import com.benidict.network.remotesource.games.paging.GamePagingDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameRemoteSourceImpl @Inject constructor(
    private val nbaServiceApi: NbaServiceApi
) {

    companion object {
        const val PAGE_SIZE = 10
    }

    suspend fun loadGameDetails(id: String): Game {
        return withContext(Dispatchers.IO) {
            nbaServiceApi.loadGameDetails(API_KEY, id).data.toDomain()
        }
    }

    fun loadGames(): Flow<PagingData<Game>> = Pager(
        config = PagingConfig(
            pageSize = PAGE_SIZE
        ),
        pagingSourceFactory = {
            GamePagingDataSource(
                nbaServiceApi = nbaServiceApi
            )
        }
    ).flow
}