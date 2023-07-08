package com.benidict.nba_stats.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.benidict.nba_stats.navigation.NavGraph
import com.benidict.nba_stats.navigation.NavRoute

fun NavGraphBuilder.landingNavGraph(navController: NavHostController) {
    navigation(
        route = NavGraph.LANDING_GRAPH,
        startDestination = NavRoute.LANDING_ROUTE
    ) {
        composable(route = NavRoute.LANDING_ROUTE) {
            navController.apply {
                navController.popBackStack()
                navController.navigate(NavGraph.HOME_GRAPH)
            }
        }
    }
}