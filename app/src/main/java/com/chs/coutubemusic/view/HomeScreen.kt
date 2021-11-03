package com.chs.coutubemusic.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chs.coutubemusic.ui.theme.ChipDisableColor
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        TopCategory()
    }
}

@Composable
fun TopCategory() {
    Row {
        Button(
            onClick = {},
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "운동",
                fontSize = 12.sp,
                color = Color.Black
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "집중",
                fontSize = 12.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "휴식",
                fontSize = 12.sp,
                color = Color.White
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "출퇴근 & 등하교",
                fontSize = 12.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun horizontalAlbum() {
    Text(
        modifier = Modifier
            .padding(
                start = 8.dp,
                top = 8.dp,
            ),
        text = "즐겨 듣는 음악",
        fontSize = 24.sp,
        color = Color.White,
    )
    LazyRow(
        modifier = Modifier.fillMaxWidth()
    ) {
    }
}


@Preview
@Composable
fun previewHome() {
    CoutubeMusicTheme {
        HomeScreen()
    }
}