package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.nba_stats.feature.home.HomeScreen
import com.benidict.nba_stats.navigation.Graph

@Composable
fun MainNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.MAIN_GRAPH.name,
        startDestination = Graph.LANDING_GRAPH.name
    ) {
       landingNavGraph(navController = navController)

        composable(route = Graph.HOME_GRAPH.name){
            HomeScreen()
        }
    }
}