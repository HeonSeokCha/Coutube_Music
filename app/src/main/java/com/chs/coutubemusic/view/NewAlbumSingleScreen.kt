package com.chs.coutubemusic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chs.coutubemusic.Screen

@Composable
fun NewAlbumSingleScreen(navController: NavHostController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                        Text("앨범 및 싱글")
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        NewAlbumSingleList(navController)
    }
}

@Composable
fun NewAlbumSingleList(navController: NavHostController) {
    LazyColumn {
        items(10) {
            LazyRow {
                items(2) {
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
                                painter = painterResource(id = com.chs.coutubemusic.R.drawable.test2),
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
            }
        }
    }
}