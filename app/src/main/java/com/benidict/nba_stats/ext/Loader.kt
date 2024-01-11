package com.benidict.nba_stats.ext

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun CenteredCircularProgressIndicator() = CircularProgressIndicator(
    Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
)