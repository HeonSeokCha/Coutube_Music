package com.chs.coutubemusic.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.chs.coutubemusic.BOTTOM_GRAPH_ROUTE
import com.chs.coutubemusic.Screen
import com.chs.coutubemusic.view.*



fun NavGraphBuilder.bottomNavGraph(
    navController: NavHostController,
) {
    navigation(
        startDestination = Screen.Home.route,
        route = BOTTOM_GRAPH_ROUTE
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Explore.route) {
            ExploreScreen(navController)
        }
        composable(Screen.Library.route) {
            LibraryScreen(navController)
        }
        composable(Screen.MusicPlayerList.route) {
            MusicPlaylistScreen(navController)
        }

        composable(Screen.MusicPlayerScreen.route) {
            MusicPLayerScreen()
        }
    }
}