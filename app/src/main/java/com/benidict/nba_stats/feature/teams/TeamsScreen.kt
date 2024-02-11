package com.benidict.nba_stats.feature.teams

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.benidict.domain.model.Team
import com.benidict.nba_stats.ext.CenteredCircularProgressIndicator
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.feature.teams.list.TeamList

@Composable
fun TeamsScreen(onClickTeam: (Team) -> Unit) {
    val viewModel = hiltViewModel<TeamViewModel>()
    Column(modifier = Modifier.fillMaxSize()) {
        56.SpaceMaxWidth()
        TeamList(viewModel = viewModel, loaderShow = { isShow ->
            if (isShow)
                CenteredCircularProgressIndicator()
        }, onClickTeam =  {
            onClickTeam(it)
        })
    }
}