package com.chs.coutubemusic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import com.chs.coutubemusic.R
import com.chs.coutubemusic.Screen
import com.chs.coutubemusic.ui.theme.ChipDisableColor

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            TopCategory()
            VerticalAlbum(navController)
        }
    }
}

@Composable
fun TopCategory() {
    val categoryList: List<String> = listOf(
        "운동",
        "집중",
        "휴식",
        "출퇴근 & 등하교"
    )
    LazyRow {
        items(categoryList) { idx ->
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape),
                colors = ButtonDefaults.buttonColors(backgroundColor = ChipDisableColor)
            ) {
                Text(
                    text = idx,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun HorizontalAlbum(
    navController: NavHostController,
    title: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ),
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.White,
        )

        LazyRow {
            items(count = 10) {
                ItemAlbumCard(navController)
            }
        }
    }
}

@Composable
fun ItemAlbumCard(navController: NavHostController) {
    Card(
        modifier = Modifier
            .background(Color.Black)
            .width(180.dp)
            .wrapContentHeight()
            .padding(10.dp, 4.dp, 5.dp, 0.dp)
            .clickable {
                navController.navigate(route = Screen.MusicPlayerList.route)
            }
    ) {
        Column(
            modifier = Modifier.background(Color.Black),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.test2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(15f)),
                contentScale = ContentScale.FillHeight
            )

            Text(
                text = "Lofi_HipHop",
                color = Color.White,
                fontSize = 14.sp,
                modifier = Modifier.padding(
                    start = 4.dp,
                    end = 4.dp,
                    top = 4.dp,
                    bottom = 4.dp
                )
            )

            Text(
                text = "재생목록 , 차현석, 노래 59곡",
                color = Color.Gray,
                fontSize = 11.sp,
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun VerticalAlbum(
    navController: NavHostController
) {
    var titleList: List<String> = listOf(
        "즐겨 듣는 음악",
        "내 기록에서",
        "맞춤 믹스",
        "내 보관함에 있는 음악"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn {
            items(count = 4) { itemIdx ->
                HorizontalAlbum(
                    navController = navController,
                    title = titleList[itemIdx]
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewAlbumList() {
    HorizontalAlbum(navController = rememberNavController(), "즐겨 듣는 음악")
}