package com.chs.coutubemusic.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.chs.coutubemusic.BOTTOM_GRAPH_ROUTE
import com.chs.coutubemusic.MAIN_GRAPH_ROUTE
import com.chs.coutubemusic.ROOT_GRAPH_ROUTE
import com.chs.coutubemusic.Screen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = BOTTOM_GRAPH_ROUTE,
        route = ROOT_GRAPH_ROUTE,
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        bottomNavGraph(navController)
    }
}