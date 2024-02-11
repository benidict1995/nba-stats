package com.benidict.nba_stats.feature.games.details

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun GameDetailsScreen(
    gameId: Int
) {
    val viewModel = hiltViewModel<GameDetailsViewModel>()
    LaunchedEffect(Unit) {
        viewModel.loadGameDetails(gameId.toString())
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        


    }
}

@Preview(
    showBackground = true
)
@Composable
fun gameDetailsScreenPreview() {

}