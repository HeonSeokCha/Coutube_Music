package com.chs.coutubemusic.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material.icons.twotone.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chs.coutubemusic.Appbar
import com.chs.coutubemusic.Screen
import com.chs.coutubemusic.model.Music
import com.chs.coutubemusic.R

@Composable
fun MusicPlaylistScreen(navController: NavHostController) {
    val music: Music = Music(
        "RAINING IN PARIS (Lofi HipHop)",
        "",
        "차현석",
        "18:38"
    )
    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                PlayListInfo(
                    title = "Lofi_HipHop",
                    author = "차현석",
                    listSize = "59"
                )
            }
            items(count = 30) {
                MusicListItem(music = music, navController = navController)
            }
        }
    }
}

@Composable
fun PlayListInfo(
    title: String,
    author: String,
    listSize: String
) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Row {
            Image(
                painterResource(id = R.drawable.test2),
                contentDescription = null,
                modifier = Modifier
                    .width(190.dp)
                    .height(190.dp)
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(start = 8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Color.White
                )

                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "소유자: ${author}님",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = "재생목록 노래 ${listSize}곡",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Row(modifier = Modifier.padding(top = 8.dp)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_music_player_add),
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_music_player_download),
                            contentDescription = null
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_music_player_option),
                            contentDescription = null
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                modifier = Modifier.width(160.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_shuffle),
                    contentDescription = null,
                    tint = Color.Black
                )
                Text(text = "셔플", color = Color.Black)
            }

            OutlinedButton(
                modifier = Modifier.width(160.dp),
                onClick = { },
                border = BorderStroke(1.dp, Color.White), // = 50% percent
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = null,
                    tint = Color.White
                )
                Text(text = "재생", color = Color.White)
            }
        }
        Text(
            text = "인싸들은 안다는 그 감성! 깨진 질감이 오히려 느낌을 살려주는 로파이 힙합 비트들과 편안한 시간을 보내세요.",
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun MusicListItem(music: Music, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp, bottom = 8.dp)
            .clickable {
                navController.navigate(route = Screen.MusicPlayerScreen.route)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.test2),
            contentDescription = null,
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 16.dp, end = 16.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(top = 4.dp)
                .wrapContentSize()
        ) {
            Text(
                text = music.title,
                fontSize = 14.sp,
                color = Color.White
            )

            Text(
                text = "${music.author}  ${music.length}",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }
}


@Preview
@Composable
fun PreviewMusicPlayerList() {
    MusicPlaylistScreen(navController = rememberNavController())
}