package com.chs.coutubemusic



sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Explore : Screen(route = "explore")
    object Library : Screen(route = "library")
    object MusicPlayerList: Screen(route = "musicPlayerList")
    object MusicPlayerScreen: Screen(route = "musicPlayerScreen")
    object NewAlbumSingleScreen: Screen(route = "newAlbumSingleScreen")
    object MoodGenreScreen: Screen(route = "moodGenreScreen")
    object MusicVideoScreen: Screen(route = "musicVideoScreen")
    object NewAlbumScreen: Screen(route = "newAlbumScreen")
    object SearchScreen: Screen(route = "searchScreen")
}