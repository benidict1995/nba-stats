package com.benidict.data.usecase.games

import androidx.paging.PagingData
import com.benidict.data.repository.games.GamesRepositoryImpl
import com.benidict.domain.model.Game
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadGamesUseCase @Inject constructor(
    private val gamesRepositoryImpl: GamesRepositoryImpl
) {

    fun execute(): Flow<PagingData<Game>> {
        return gamesRepositoryImpl.loadGames()
    }
}