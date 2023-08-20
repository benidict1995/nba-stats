package com.benidict.nba_stats.feature.teams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.feature.teams.list.TeamList

@Composable
fun TeamsScreen() {
    val viewModel = hiltViewModel<TeamViewModel>()
    Column(modifier = Modifier.fillMaxSize()) {
        56.SpaceMaxWidth()
        TeamList(viewModel = viewModel)
    }
}