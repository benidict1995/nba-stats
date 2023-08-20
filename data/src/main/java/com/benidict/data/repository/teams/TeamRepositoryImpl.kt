package com.benidict.data.repository.teams

import androidx.paging.PagingData
import com.benidict.domain.model.Team
import com.benidict.network.remotesource.teams.TeamRemoteSourceImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamRemoteSourceImpl: TeamRemoteSourceImpl
){

    fun loadTeams(): Flow<PagingData<Team>>
        = teamRemoteSourceImpl.loadTeams()
}