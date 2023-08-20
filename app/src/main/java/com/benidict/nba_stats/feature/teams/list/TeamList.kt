package com.benidict.nba_stats.feature.teams.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.benidict.domain.model.Team
import com.benidict.nba_stats.component.card.TeamCard
import com.benidict.nba_stats.ext.LoadPagingStateItem
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.feature.teams.TeamViewModel

@Composable
fun TeamList(viewModel: TeamViewModel) {
    LaunchedEffect(Unit) {
        viewModel.loadTeams()
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        val teams = viewModel.teamsPagingState.collectAsLazyPagingItems()
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(teams.itemCount) { index ->
                8.SpaceMaxWidth()
                TeamCard(teams[index] as Team)
            }
        }
        teams.LoadPagingStateItem(
            loadingRefresh = {
                //CircularProgressIndicator()
            },
            loadingAppend = {
                //CircularProgressIndicator()
            },
            errorRefresh = {

            },
            errorAppend = {

            }
        )
    }
}