package com.benidict.nba_stats.feature.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.benidict.nba_stats.R
import com.benidict.nba_stats.component.bottombar.BottomBar
import com.benidict.nba_stats.navigation.graph.HomeNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navHostController: NavHostController = rememberNavController()) {
    val titleBar = remember {
        mutableStateOf("")
    }

    val hasBackButton = remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
                navigationIcon = {
                    if (hasBackButton.value) {
                        IconButton(onClick = {
                            navHostController.navigateUp()
                        }) {
                            Icon(Icons.Rounded.ArrowBack, "", tint = Color.White)
                        }
                    } else {
                        null
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text(
                        fontWeight = FontWeight.Medium,
                        text = titleBar.value,
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            )
        },
        bottomBar = { BottomBar(navController = navHostController) }
    ) { _ ->
        HomeNavGraph(navController = navHostController, onSelectedScreen = {
            titleBar.value = it
        }, hasBackButton = {
            hasBackButton.value = it
        })
    }
}