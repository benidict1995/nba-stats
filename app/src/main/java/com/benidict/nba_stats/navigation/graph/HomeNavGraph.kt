package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.nba_stats.feature.games.GamesScreen
import com.benidict.nba_stats.feature.stats.StatsScreen
import com.benidict.nba_stats.feature.teams.TeamsScreen
import com.benidict.nba_stats.navigation.NavGraph
import com.benidict.nba_stats.navigation.NavRoute

@Composable
fun HomeNavGraph(navController: NavHostController, onSelectedScreen: (String) -> Unit) {
    NavHost(
        navController = navController,
        route = NavGraph.HOME_GRAPH,
        startDestination = NavRoute.TEAMS_ROUTE
    ) {
        composable(route = NavRoute.TEAMS_ROUTE) {
            onSelectedScreen("Teams")
            TeamsScreen()
        }
        composable(route = NavRoute.GAMES_ROUTE) {
            onSelectedScreen("Games")
            GamesScreen()
        }
        composable(route = NavRoute.STATS_ROUTE) {
            onSelectedScreen("Statistics")
            StatsScreen()
        }
    }
}