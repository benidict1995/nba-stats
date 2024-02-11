package com.benidict.data.usecase.games

import com.benidict.data.repository.games.GamesRepositoryImpl
import com.benidict.domain.model.Game
import javax.inject.Inject

class LoadGameByIdUseCase @Inject constructor(
    private val gamesRepositoryImpl: GamesRepositoryImpl
) {
    suspend fun execute(id: String): Game {
        return gamesRepositoryImpl.loadGameDetails(id)
    }
}