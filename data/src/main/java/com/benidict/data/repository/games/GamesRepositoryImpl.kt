package com.benidict.data.repository.games

import androidx.paging.PagingData
import com.benidict.domain.model.Game
import com.benidict.network.remotesource.games.GameRemoteSourceImpl
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GamesRepositoryImpl @Inject constructor(
    private val gameRemoteSourceImpl: GameRemoteSourceImpl
) {
    fun loadGames(): Flow<PagingData<Game>>
     = gameRemoteSourceImpl.loadGames()
}