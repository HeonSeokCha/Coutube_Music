package com.chs.coutubemusic.view

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chs.coutubemusic.model.Music

@Composable
fun MusicPlaylistScreen() {
    val music: Music = Music(
        "RAINING IN PARIS (Lofi HipHop)",
        "",
        "차현석",
        "18:38"
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            PlayListInfo(
                title = "Lofi_HipHop",
                author = "차현석",
                listSize = "59")
        }
        items(count = 30) {
            MusicListItem(music = music)
        }
    }
}

@Composable
fun PlayListInfo(
    title: String,
    author: String,
    listSize: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(5.dp))
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
                fontSize = 22.sp,
                color = Color.White
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "제공: ${author}님",
                fontSize = 14.sp,
                color = Color.White
            )

            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = "재생목록 노래 ${listSize}곡",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun MusicListItem(music: Music) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp, bottom = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .width(100.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(5.dp))
                .padding(start = 16.dp, end = 16.dp)
        )
        
        Column(
            modifier = Modifier.wrapContentSize()
        ) {
            Text(
                text = music.title,
                fontSize = 18.sp,
                color = Color.White
            )

            Text(
                text = "${music.author}  ${music.length}",
                fontSize = 14.sp,
                color = Color.White
            )
        }
        
        IconButton(onClick = { /*TODO*/ }) {
        }
    }
}