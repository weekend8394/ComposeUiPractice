package com.cockroach.composeuipractice.ui.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cockroach.composeuipractice.ui.BottomBarScreen
import com.cockroach.composeuipractice.ui.screen.HomeScreen
import com.cockroach.composeuipractice.ui.screen.LibraryScreen
import com.cockroach.composeuipractice.ui.screen.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen()
        }

        composable(route = BottomBarScreen.Search.route) {
            SearchScreen()
        }

        composable(route = BottomBarScreen.Library.route) {
            LibraryScreen()
        }
    }
}