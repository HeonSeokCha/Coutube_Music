package com.chs.coutubemusic

import androidx.navigation.NavController
import androidx.navigation.NavHostController

const val ROOT_GRAPH_ROUTE = "root"
const val MAIN_GRAPH_ROUTE = "main"
const val BOTTOM_GRAPH_ROUTE = "bottom"

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Explore : Screen(route = "explore")
    object Library : Screen(route = "library")
    object MusicPlayerList: Screen(route = "musicPlayerList")
    object MusicPlayerScreen: Screen(route = "musicPlayerScreen")
    object NewMusicAlbumScreen: Screen(route = "newMusicAlbumScreen")
}