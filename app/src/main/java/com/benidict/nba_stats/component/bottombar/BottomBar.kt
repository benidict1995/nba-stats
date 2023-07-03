package com.benidict.nba_stats.component.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: BottomBar(
        route = "home",
        title = "HOME",
        icon = Icons.Default.Home
    )
}