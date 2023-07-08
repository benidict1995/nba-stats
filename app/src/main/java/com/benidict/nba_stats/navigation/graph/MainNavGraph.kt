package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.nba_stats.feature.home.HomeScreen
import com.benidict.nba_stats.navigation.NavGraph

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = NavGraph.MAIN_GRAPH,
        startDestination = NavGraph.LANDING_GRAPH
    ) {
       landingNavGraph(navController = navController)

        composable(route = NavGraph.HOME_GRAPH){
            HomeScreen()
        }
    }
}