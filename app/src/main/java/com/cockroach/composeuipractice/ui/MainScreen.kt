package com.cockroach.composeuipractice.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cockroach.composeuipractice.R
import com.cockroach.composeuipractice.ui.navgraph.BottomNavGraph
import com.cockroach.composeuipractice.ui.theme.spotifyGray

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val bottomNavItems = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Search,
        BottomBarScreen.Library
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination

        val dimension by remember {
            mutableStateOf(arrayListOf(20, 20, 20))
        }

        bottomNavItems.forEach { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentRoute,
                navController = navController,
                dimension = dimension
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    dimension: ArrayList<Int>
) {
    BottomNavigationItem(
        label = { Text(text = screen.title) },
        icon = {
            Icon(
                painter = painterResource(id = screen.icon),
                contentDescription = "",
                modifier = Modifier
                    .width(dimension[screen.index].dp)
                    .height(dimension[screen.index].dp)
                    .animateContentSize()
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            screen.func.invoke()
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
            dimension.forEachIndexed { index, _ ->
                if (index == screen.index)
                    dimension[index] = 25
                else
                    dimension[index] = 20
            }
        },
        modifier = Modifier
            .background(spotifyGray)
            .animateContentSize(),
        alwaysShowLabel = true
    )
}

sealed class BottomBarScreen(val route: String, val title: String, val icon: Int, val index: Int, val func: () -> Unit) {
    object Home : BottomBarScreen("Home", "Home", R.drawable.ic_home_normal, 0, {})
    object Search : BottomBarScreen("Search", "Search", R.drawable.ic_search_normal, 1, {})
    object Library : BottomBarScreen("Library", "Library", R.drawable.ic_library_normal, 2, {})
}
