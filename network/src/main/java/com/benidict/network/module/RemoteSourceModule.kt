package com.benidict.network.module

import com.benidict.network.NbaServiceApi
import com.benidict.network.remotesource.games.GameRemoteSourceImpl
import com.benidict.network.remotesource.teams.TeamRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteSourceModule {

    @Singleton
    @Provides
    fun providesTeamRemoteSource(
        nbaServiceApi: NbaServiceApi
    ) = TeamRemoteSourceImpl(
        nbaServiceApi = nbaServiceApi
    )

    @Singleton
    @Provides
    fun providesGamesRemoteSource(
        nbaServiceApi: NbaServiceApi
    ) = GameRemoteSourceImpl(
        nbaServiceApi = nbaServiceApi
    )
}