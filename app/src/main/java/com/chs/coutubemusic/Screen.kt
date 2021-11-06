package com.chs.coutubemusic

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Explore : Screen(route = "explore")
    object Library : Screen(route = "library")
    object MusicPlayerList: Screen(route = "musicPlayerList")
}