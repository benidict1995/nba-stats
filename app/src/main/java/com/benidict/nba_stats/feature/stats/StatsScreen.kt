package com.benidict.nba_stats.feature.stats

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.feature.stats.list.StatisticList

@Composable
fun StatsScreen(){
    val viewModel = hiltViewModel<StatsViewModel>()
    Column(modifier = Modifier.fillMaxSize()) {
        56.SpaceMaxWidth()
        StatisticList(viewModel = viewModel)
    }
}