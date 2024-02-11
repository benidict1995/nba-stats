package com.benidict.nba_stats.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.benidict.domain.model.Team
import com.benidict.domain.util.fromJson
import com.benidict.domain.util.toJson
import com.benidict.nba_stats.ext.hasBackButton
import com.benidict.nba_stats.feature.games.GamesScreen
import com.benidict.nba_stats.feature.games.details.GameDetailsScreen
import com.benidict.nba_stats.feature.stats.StatsScreen
import com.benidict.nba_stats.feature.teams.TeamsScreen
import com.benidict.nba_stats.feature.teams.details.TeamDetailsScreen
import com.benidict.nba_stats.navigation.Graph
import com.benidict.nba_stats.navigation.Screen

@Composable
fun HomeNavGraph(navController: NavHostController, onSelectedScreen: (String) -> Unit, hasBackButton: hasBackButton) {
    NavHost(
        navController = navController,
        route = Graph.HOME_GRAPH.name,
        startDestination = Screen.TEAM.name
    ) {
        composable(route = Screen.TEAM.name) {
            hasBackButton(false)
            onSelectedScreen("Teams")
            TeamsScreen {
                navController.navigate("${Screen.TEAM_DETAILS.name}/${it.toJson()}")
            }
        }
        composable(route = Screen.GAMES.name) {
            hasBackButton(false)
            onSelectedScreen("Games")
            GamesScreen { id ->
                navController.navigate("${Screen.GAME_DETAILS.name}/$id")
            }
        }
        composable(route = Screen.STATS.name) {
            hasBackButton(false)
            onSelectedScreen("Statistics")
            StatsScreen()
        }
        composable(route = "${Screen.TEAM_DETAILS.name}/{team}") {
            it.arguments?.getString("team")?.let { jsonString ->
                val team = jsonString.fromJson(Team::class.java)
                hasBackButton(true)
                onSelectedScreen(team.name)
                TeamDetailsScreen(team)
            }
        }
        composable(route = "${Screen.GAME_DETAILS.name}/{id}") {
            it.arguments?.getString("id")?.let { id ->
                hasBackButton(true)
                //onSelectedScreen(t)
                GameDetailsScreen(id.toInt())
            }
        }
    }
}