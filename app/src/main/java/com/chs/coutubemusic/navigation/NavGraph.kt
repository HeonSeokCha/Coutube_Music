package com.chs.coutubemusic.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chs.coutubemusic.MAIN_GRAPH_ROUTE
import com.chs.coutubemusic.ROOT_GRAPH_ROUTE

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = MAIN_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ) {
        mainNavGraph(navController)
        bottomNavGraph(navController)
    }
}