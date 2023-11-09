package com.benidict.nba_stats.feature.games

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.benidict.data.usecase.games.LoadGamesUseCase
import com.benidict.domain.model.Game
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val loadGamesUseCase: LoadGamesUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<PagingData<Game>> = MutableStateFlow(
        value = PagingData.empty()
    )
    val state = _state.asStateFlow()

    fun loadGames() {
        viewModelScope.launch {
            loadGamesUseCase.execute()
                .distinctUntilChanged()
                .cachedIn(viewModelScope)
                .collectLatest {
                    _state.value = it
                }
        }
    }
}