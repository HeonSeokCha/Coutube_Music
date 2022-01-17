package com.chs.coutubemusic.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chs.coutubemusic.Screen
import com.chs.coutubemusic.view.*

@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetUpNavGraph(
    bottomNavController: NavHostController,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = bottomNavController,
        startDestination = Screen.Home.route,
        modifier = Modifier
            .padding(bottom = paddingValues.calculateBottomPadding())
    ) {
        composable(Screen.Home.route) {
            HomeScreen(bottomNavController)
        }
        composable(Screen.Explore.route) {
            ExploreScreen(bottomNavController)
        }
        composable(Screen.Library.route) {
            LibraryScreen(bottomNavController)
        }
        composable(Screen.MusicPlayerList.route) {
            MusicPlaylistScreen(bottomNavController)
        }
        composable(Screen.MusicPlayerScreen.route) {
            MusicPlayerScreen(bottomNavController)
        }
        composable(Screen.NewAlbumSingleScreen.route) {
            NewAlbumSingleScreen(bottomNavController)
        }
        composable(Screen.MoodGenreScreen.route) {
            MoodGenreScreen(bottomNavController)
        }
        composable(Screen.MusicVideoScreen.route) {
            MusicVideoScreen(bottomNavController)
        }
        composable(Screen.NewAlbumScreen.route) {
            NewAlbumScreen(bottomNavController)
        }
    }
}
