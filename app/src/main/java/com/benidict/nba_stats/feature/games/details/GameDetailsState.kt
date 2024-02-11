package com.benidict.nba_stats.feature.games.details

sealed class GameDetailsState {
    object ShowLoading: GameDetailsState()
}