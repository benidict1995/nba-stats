package com.benidict.nba_stats.feature.games.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benidict.data.usecase.games.LoadGameByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameDetailsViewModel @Inject constructor(
    private val loadGameByIdUseCase: LoadGameByIdUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<GameDetailsState> = MutableStateFlow(
        GameDetailsState.ShowLoading
    )

    val state = _state.asStateFlow()

    fun loadGameDetails(
        id: String
    ) {
        viewModelScope.launch {
            loadGameByIdUseCase.execute(id)
        }
    }
}