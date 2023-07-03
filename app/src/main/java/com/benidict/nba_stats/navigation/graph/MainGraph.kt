package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.benidict.nba_stats.navigation.graph.Route.MAIN_GRAPH
import com.benidict.nba_stats.navigation.graph.Route.SPLASH_GRAPH

@Composable
fun MainGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = MAIN_GRAPH,
        startDestination = SPLASH_GRAPH
    ) {

    }
}

object Route {
    const val MAIN_GRAPH = "MAIN_GRAPH"
    const val SPLASH_GRAPH = "SPLASH_GRAPH"
}