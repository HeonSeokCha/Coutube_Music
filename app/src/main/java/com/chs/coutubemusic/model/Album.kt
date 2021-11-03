package com.chs.coutubemusic.model

import androidx.compose.ui.graphics.vector.ImageVector

data class Album(
    val title: String,
    val playList: String,
    val count: Int,
    val image: ImageVector
)
