package com.benidict.data.module

import com.benidict.data.repository.games.GamesRepositoryImpl
import com.benidict.data.repository.teams.TeamRepositoryImpl
import com.benidict.data.usecase.games.LoadGamesUseCase
import com.benidict.data.usecase.teams.LoadTeamsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun providesLoadTeamsUseCase(
        teamRepositoryImpl: TeamRepositoryImpl
    ) = LoadTeamsUseCase(teamRepositoryImpl)

    @Provides
    @ViewModelScoped
    fun providesLoadGamesUseCase(
        gamesRepositoryImpl: GamesRepositoryImpl
    ) = LoadGamesUseCase(gamesRepositoryImpl)
}