package com.benidict.nba_stats.feature.games

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.benidict.nba_stats.ext.CenteredCircularProgressIndicator
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.feature.games.list.GameList

@Composable
fun GamesScreen() {
    val viewModel = hiltViewModel<GamesViewModel>()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        56.SpaceMaxWidth()
        GameList(viewModel = viewModel, loaderShow = { isShow ->
            if (isShow)
                CenteredCircularProgressIndicator()
        })

    }
}