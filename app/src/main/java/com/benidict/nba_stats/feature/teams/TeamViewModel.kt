package com.benidict.nba_stats.feature.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.benidict.data.usecase.teams.LoadTeamsUseCase
import com.benidict.domain.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val loadTeamsUseCase: LoadTeamsUseCase
) : ViewModel() {

    private val _teamsPagingState: MutableStateFlow<PagingData<Team>> = MutableStateFlow(
        value = PagingData.empty()
    )
    val teamsPagingState = _teamsPagingState.asStateFlow()

    fun loadTeams() {
        viewModelScope.launch {
            loadTeamsUseCase.execute()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collectLatest {
                    _teamsPagingState.value = it
                }
        }
    }

}