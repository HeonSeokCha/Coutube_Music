package com.chs.coutubemusic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chs.coutubemusic.R
import com.chs.coutubemusic.Screen
import com.chs.coutubemusic.domain.model.Music
import com.chs.coutubemusic.ui.theme.GenreMoodColor

@Composable
fun ExploreScreen(navController: NavHostController) {
    val exploreTopItems: List<Pair<String, Painter>> = listOf(
        "새 앨범" to painterResource(id = R.drawable.ic_new_album),
        "차트" to painterResource(id = R.drawable.ic_chart),
        "분위기 및 장르" to painterResource(id = R.drawable.ic_feel),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            items(3) { idx ->
                ExploreTopItem(exploreTopItems[idx], navController)
            }
            item {
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
                NewAlbumSingle(title = "새 앨범 및 싱글", navController = navController)
            }
            item {
                PopularSongs(navController, "인기곡")
            }
//            item {
//                MoodGenreList(navController)
//            }
            item {
                PopularSongs(navController, "인기")
            }
            item {
                NewMusicVideo(navController)
            }
        }
    }
}

@Composable
fun NewAlbumSingle(
    title: String,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
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

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { navController.navigate(Screen.NewAlbumSingleScreen.route) }) {
            Text(text = "모두 보기", color = Color.Gray)
        }
    }
    LazyRow {
        items(count = 10) {
            ItemAlbumCard(navController)
        }
    }
}

@Composable
fun PopularSongs(navController: NavHostController, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
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

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { navController.navigate(Screen.MusicPlayerList.route) }) {
            Text(text = "모두 보기", color = Color.Gray)
        }
    }
    LazyRow {
        items(count = 6) {
            Column {
                ItemPopularSong(Music("ELEVEN", "", "IVE(아이브)", ""), navController)
                ItemPopularSong(Music("Savage", "", "aespa", ""), navController)
                ItemPopularSong(Music("Celebrity", "", "아이유(IU)", ""), navController)
                ItemPopularSong(Music("Next Level", "", "aespa", ""), navController)
            }
        }
    }
}

@Composable
fun MoodGenreList(navController: NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                text = "분위기 및 장르",
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.White,
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = { navController.navigate(Screen.MoodGenreScreen.route) }) {
                Text(text = "모두 보기", color = Color.Gray)
            }
        }

        LazyRow(
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(count = 13) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    ItemGenre("댄스 & 일렉트로닉")
                    ItemGenre("계절 & 테마")
                    ItemGenre("1990년대")
                }
            }
        }
    }
}

@Composable
fun ItemGenre(title: String) {
    Card(
        modifier = Modifier
            .width(150.dp)
            .height(48.dp),
        shape = RoundedCornerShape(15f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GenreMoodColor),
        ) {
            Box(
                modifier = Modifier
                    .width(6.dp)
                    .fillMaxHeight()
                    .background(Color.Cyan)
            )
            Text(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        bottom = 15.dp,
                        top = 15.dp
                    ),
                text = "$title",
                maxLines = 2,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun ExploreTopItem(
    item: Pair<String, Painter>,
    navController: NavHostController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
            .clickable {
                       when(item.first) {
                           "새 앨범" -> {
                               navController.navigate(Screen.NewAlbumScreen.route)
                           }
                           "차트" -> {

                           }
                           "분위기 및 장르" -> {
                               navController.navigate(Screen.MoodGenreScreen.route)
                           }
                       }
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = item.second,
            contentDescription = null,
        )
        Text(
            text = item.first,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}

@Composable
fun ItemPopularSong(song: Music, navController: NavHostController) {
    Row(
        modifier = Modifier
            .width(320.dp)
            .clickable {
                navController.navigate(Screen.MusicPlayerScreen.route)
            }
    ) {
        Image(
            painter = painterResource(id = R.drawable.test2),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .width(48.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(5f)),
            contentScale = ContentScale.FillHeight
        )
        Spacer(modifier = Modifier.padding(start = 8.dp))
        Text(text = "1")
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(text = song.title)
            Text(
                text = song.author,
                fontSize = 13.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun NewMusicVideo(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    bottom = 8.dp
                ),
            text = "새 뮤직비디오",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = Color.White,
        )

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = { navController.navigate(Screen.MusicVideoScreen.route) }) {
            Text(text = "모두 보기", color = Color.Gray)
        }
    }

    LazyRow(modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)) {
        items(count = 6) {
            ItemMusicVideo(
                navController,
                Modifier
                    .padding(end = 16.dp)
                    .width(300.dp)
                    .wrapContentHeight()
            )
        }
    }
}

@Composable
fun ItemMusicVideo(
    navController: NavHostController,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .clickable {
                navController.navigate(Screen.MusicPlayerScreen.route)
            },
    ) {
        Card(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                painterResource(id = R.drawable.test2),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Love is like watching start with you(사랑은 너와 별을 보는 것)",
            color = Color.White
        )
        Text(
            text = "디셈버(December) 조회수 1만회",
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}