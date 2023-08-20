package com.benidict.data.usecase.teams

import androidx.paging.PagingData
import com.benidict.data.repository.teams.TeamRepositoryImpl
import com.benidict.domain.model.Team
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadTeamsUseCase @Inject constructor(
    private val teamRepositoryImpl: TeamRepositoryImpl
) {
    fun execute(): Flow<PagingData<Team>> {
        return teamRepositoryImpl.loadTeams()
    }
}