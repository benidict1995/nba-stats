package com.benidict.nba_stats.feature.games.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import com.benidict.domain.model.Game
import com.benidict.nba_stats.component.card.GameCard
import com.benidict.nba_stats.ext.LoadPagingStateItem
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.ext.onLoaderShow
import com.benidict.nba_stats.feature.games.GamesViewModel


@Composable
fun GameList(viewModel: GamesViewModel, loaderShow: onLoaderShow) {
    LaunchedEffect(Unit) {
        viewModel.loadGames()
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        val games = viewModel.state.collectAsLazyPagingItems()
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(games.itemCount) { index ->
                8.SpaceMaxWidth()
                GameCard(game = games[index] as Game)
            }
        }
        games.LoadPagingStateItem(
            loadingRefresh = {
                loaderShow(true)
            },
            loadingAppend = {
                loaderShow(false)
            },
            errorRefresh = {

            },
            errorAppend = {

            }
        )
    }
}