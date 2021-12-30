package com.chs.coutubemusic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chs.coutubemusic.Appbar
import com.chs.coutubemusic.R

@Composable
fun LibraryScreen(navController: NavHostController) {
    val exploreTopItems: List<Pair<String, Painter>> = listOf(
        "오프라인 저장 콘텐츠" to painterResource(id = R.drawable.ic_music_player_download),
        "재생목록" to painterResource(id = R.drawable.ic_play_list),
        "앨범" to painterResource(id = R.drawable.ic_new_album),
        "노래" to painterResource(id = R.drawable.ic_music),
        "아티스트" to painterResource(id = R.drawable.ic_artist),
        "구독" to painterResource(id = R.drawable.ic_subscriptions)
    )

    Scaffold(
        topBar = {
            Appbar()
        }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            LazyColumn {
                item {
                    HorizontalAlbum(
                        navController = navController,
                        title = "최근 활동"
                    )
                }

                items(count = 6) { idx ->
                    ExploreTopItem(exploreTopItems[idx])
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewLibrary() {
    val exploreTopItems: List<Pair<String, Painter>> = listOf(
        "오프라인 저장 콘텐츠" to painterResource(id = R.drawable.ic_music_player_download),
        "재생목록" to painterResource(id = R.drawable.ic_play_list),
        "앨범" to painterResource(id = R.drawable.ic_new_album),
        "노래" to painterResource(id = R.drawable.ic_music),
        "아티스트" to painterResource(id = R.drawable.ic_artist),
        "구독" to painterResource(id = R.drawable.ic_subscriptions)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn {
            item {
                HorizontalAlbum(
                    navController = rememberNavController(),
                    title = "최근 활동"
                )
            }

            items(count = 6) { idx ->
                ExploreTopItem(exploreTopItems[idx])
            }
        }
    }
}