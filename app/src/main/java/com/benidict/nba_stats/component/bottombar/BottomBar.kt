package com.benidict.nba_stats.component.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.benidict.nba_stats.navigation.NavRoute

val items = listOf(
    BottomNavItem.Home,
    BottomNavItem.Games,
    BottomNavItem.Statistics
)

@Composable
fun BottomBar(
    navController: NavHostController
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = items.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            items.forEach { item ->
                AddItem(
                    screen = item,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        // Text that shows bellow the icon
        label = {
            Text(text = screen.title)
        },

        // The icon resource
        icon = {
            Icon(
                rememberVectorPainter(image = screen.icon),
                contentDescription = screen.title
            )
        },

        // Display if the icon it is select or not
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,

        // Always show the label bellow the icon or not
        alwaysShowLabel = true,
        // Click listener for the icon
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },

        // Control all the colors of the icon
        colors = NavigationBarItemDefaults.colors()
    )
}

sealed class BottomNavItem(
    var title: String,
    var route: String,
    var icon: ImageVector
) {
    object Home :
        BottomNavItem(
            title = "Home",
            route = NavRoute.TEAMS_ROUTE,
            icon = Icons.Default.Home
        )

    object Games :
        BottomNavItem(
            title = "Games",
            route = NavRoute.GAMES_ROUTE,
            icon = Icons.Default.Home
        )

    object Statistics :
        BottomNavItem(
            title = "Statistics",
            route = NavRoute.STATS_ROUTE,
            icon = Icons.Default.Home
        )
}