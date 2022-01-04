package com.chs.coutubemusic.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoodGenreScreen(navController: NavHostController) {
    val genreList1: List<String> = listOf(
        "댄스 & 일렉트로닉",
        "1990년대",
        "계절 & 테마",
        "2000년대",
        "집중할 떄",
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 8.dp,
                    top = 8.dp
                )
        ) {
            Text(
                text = "분위기\n및 장르",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            GenreMoodList("맞춤",genreList1, navController)
            Spacer(modifier = Modifier.padding(bottom = 16.dp))
            GenreMoodList("분위기 및 상황",genreList1, navController)
            Spacer(modifier = Modifier.padding(bottom = 16.dp))
            GenreMoodList("장르",genreList1, navController)
            Spacer(modifier = Modifier.padding(bottom = 16.dp))

        }
    }
}

@ExperimentalFoundationApi
@Composable
fun GenreMoodList(
    title: String,
    items: List<String>,
    navController: NavHostController) {
    Text(
        text = title,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(bottom = 16.dp)
    )

    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color.Black),
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(
            start = 4.dp,
            top = 16.dp,
            end = 4.dp,
            bottom = 16.dp
        )
    ) {
        items(items.size) { idx ->
            ItemGenre(items[idx])
        }
    }
}

@Preview
@Composable
fun PreViewMoodGenreScreen() {
    MoodGenreScreen(navController = rememberNavController())
}