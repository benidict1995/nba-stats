package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.nba_stats.feature.games.GamesScreen
import com.benidict.nba_stats.feature.stats.StatsScreen
import com.benidict.nba_stats.feature.teams.TeamsScreen
import com.benidict.nba_stats.navigation.Graph
import com.benidict.nba_stats.navigation.Screen

@Composable
fun HomeNavGraph(navController: NavHostController, onSelectedScreen: (String) -> Unit) {
    NavHost(
        navController = navController,
        route = Graph.HOME_GRAPH.name,
        startDestination = Screen.TEAM.name
    ) {
        composable(route = Screen.TEAM.name) {
            onSelectedScreen("Teams")
            TeamsScreen()
        }
        composable(route = Screen.GAMES.name) {
            onSelectedScreen("Games")
            GamesScreen()
        }
        composable(route = Screen.STATS.name) {
            onSelectedScreen("Statistics")
            StatsScreen()
        }
    }
}