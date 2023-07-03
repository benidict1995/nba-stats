package com.benidict.nba_stats.base

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.benidict.nba_stats.base.di.BaseHiltComponentActivity
import com.benidict.nba_stats.ui.theme.NbastatsTheme

abstract class BaseComponentActivity :
    BaseHiltComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NbastatsTheme {}
        }
    }
}