package com.benidict.nba_stats.ext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Int.SpaceMaxWidth(){
    Spacer(
        modifier = Modifier
            .height(height = this.dp)
            .fillMaxWidth()
            .background(color = Color.White)
    )
}