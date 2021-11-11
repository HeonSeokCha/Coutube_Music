package com.chs.coutubemusic

import androidx.navigation.NavController
import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Explore : Screen(route = "explore")
    object Library : Screen(route = "library")
    object MusicPlayerList: Screen(route = "musicPlayerList")
    object MusicPlayerScreen: Screen(route = "musicPlayerScreen")
}