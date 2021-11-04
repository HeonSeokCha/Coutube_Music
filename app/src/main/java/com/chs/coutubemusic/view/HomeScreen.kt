package com.chs.coutubemusic.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chs.coutubemusic.ui.theme.ChipDisableColor
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme
import com.chs.coutubemusic.ui.theme.Purple500

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(bottom = 56.dp)
    ) {
        TopCategory()
        VerticalAlbum()
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
                color = Color.White
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "집중",
                color = Color.White
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "휴식",
                color = Color.White
            )
        }

        Button(
            onClick = {

            },
            modifier = Modifier
                .padding(
                    start = 4.dp,
                    end = 4.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .clip(CircleShape),
            colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
        ) {
            Text(
                text = "출퇴근 & 등하교",
                color = Color.White
            )
        }
    }
}

@Composable
fun HorizontalAlbum(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    ) {
        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 8.dp,
                ),
            text = title,
            fontSize = 24.sp,
            color = Color.White,
        )

        LazyRow {
            items(count = 10) {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(120.dp)
                        .padding(10.dp, 4.dp, 5.dp, 0.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.Black),
                    elevation = 5.dp
                ) {
                    Column(
                        modifier = Modifier.padding(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp),

                            )


                        Text(
                            text = "Lofi_=HipHop",
                            color = Color.White,
                        )

                        Text(
                            text = "재생목록 , 차현석, 노래 59곡",
                            color = Color.White,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun VerticalAlbum() {
    var titleList: List<String> = listOf(
        "즐격 듣는 음악",
        "내 기록에서",
        "맞춤 믹스",
        "내 보관함에 있는 음악"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        LazyColumn {
            items(count = 4) { itemIdx ->
                HorizontalAlbum(title = titleList[itemIdx])
            }
        }
    }
}


@Preview
@Composable
fun previewHome() {
    CoutubeMusicTheme {
        HorizontalAlbum("abc")
    }
}