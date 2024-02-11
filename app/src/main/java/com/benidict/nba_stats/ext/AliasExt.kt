package com.benidict.nba_stats.ext

import androidx.compose.runtime.Composable

typealias onLoaderShow = @Composable (Boolean) -> Unit
typealias hasBackButton = @Composable (Boolean) -> Unit