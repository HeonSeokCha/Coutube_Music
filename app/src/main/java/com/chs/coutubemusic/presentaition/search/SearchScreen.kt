package com.chs.coutubemusic.presentaition.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(text = "노래 , 앨범, 아티스트 검색")
                },
                maxLines = 1,
                singleLine = true
            )
        }

    }
}