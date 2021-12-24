package com.chs.coutubemusic.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.chs.coutubemusic.MAIN_GRAPH_ROUTE
import com.chs.coutubemusic.Screen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = Screen.Home.route,
        route = MAIN_GRAPH_ROUTE
    ) {

    }
}