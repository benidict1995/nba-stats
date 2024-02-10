package com.benidict.nba_stats.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.benidict.nba_stats.navigation.Graph
import com.benidict.nba_stats.navigation.Screen

fun NavGraphBuilder.landingNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.LANDING_GRAPH.name,
        startDestination = Screen.LANDING.name
    ) {
        composable(route = Screen.LANDING.name) {
            navController.apply {
                navController.popBackStack()
                navController.navigate(Graph.HOME_GRAPH.name)
            }
        }
    }
}