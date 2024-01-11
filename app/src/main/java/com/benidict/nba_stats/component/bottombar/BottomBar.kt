package com.benidict.nba_stats.component.bottombar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.benidict.nba_stats.R
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
                    icon =
                    when (item.title) {
                        BottomNavItem.Home.title -> ImageVector.vectorResource(R.drawable.baseline_home_filled_24)
                        BottomNavItem.Games.title -> ImageVector.vectorResource(R.drawable.baseline_sports_basketball_24)
                        BottomNavItem.Statistics.title -> ImageVector.vectorResource(R.drawable.baseline_analytics_24)
                        else -> ImageVector.vectorResource(R.drawable.baseline_home_filled_24)
                    },
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
    icon: ImageVector,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        // Text that shows bellow the icon
        label = {
            Text(text = screen.title)
        },

        // rememberVectorPainter(image = screen.icon),
        // The icon resource
        icon = {
            Icon(
                rememberVectorPainter(image = icon),
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
    var route: String
) {
    object Home :
        BottomNavItem(
            title = "Home",
            route = NavRoute.TEAMS_ROUTE
        )

    object Games :
        BottomNavItem(
            title = "Games",
            route = NavRoute.GAMES_ROUTE
        )

    object Statistics :
        BottomNavItem(
            title = "Statistics",
            route = NavRoute.STATS_ROUTE
        )
}