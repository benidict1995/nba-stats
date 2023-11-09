package com.benidict.data.module

import com.benidict.data.repository.games.GamesRepositoryImpl
import com.benidict.data.repository.teams.TeamRepositoryImpl
import com.benidict.network.remotesource.games.GameRemoteSourceImpl
import com.benidict.network.remotesource.teams.TeamRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTeamRepository(
        teamRemoteSourceImpl: TeamRemoteSourceImpl
    ) = TeamRepositoryImpl(teamRemoteSourceImpl)

    @Provides
    @Singleton
    fun provideGamesRepository(
        gameRemoteSourceImpl: GameRemoteSourceImpl
    ) = GamesRepositoryImpl(
        gameRemoteSourceImpl
    )
}