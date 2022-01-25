package com.chs.coutubemusic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chs.coutubemusic.ui.theme.BottomBarColor

@Composable
fun SheetContent(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()
    }
}

@Composable
fun SheetExpanded(
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        content()
    }
}

@Composable
fun SheetCollapsed(
    isCollapsed: Boolean,
    currentFraction: Float,
    onSheetClick: () -> Unit,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(BottomBarColor)
            .graphicsLayer(alpha = if (currentFraction > 0.5f) {
                currentFraction
            } else {
                1f - (currentFraction * 2)
            })
            .noRippleClickable(
                onClick = onSheetClick,
                enabled = isCollapsed
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        content()
    }
}

@Composable
fun RowScope.CollapsedMusicPlayerScreen() {
    Image(
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .padding(start = 8.dp),
        painter = painterResource(id = R.drawable.test2),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
    Column {
        Text(
            text = "Better Than Yesterday",
            fontSize = 12.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = "MC 스나이퍼, 미스터 룸나인 & 배치기",
            fontSize = 12.sp,
            color = Color.White
        )
    }
    IconButton(
        onClick = {},
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = null)
    }
    IconButton(
        modifier = Modifier.padding(end = 8.dp),
        onClick = {},
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_play_next), contentDescription = null)
    }
}

@Composable
fun RowScope.ExpandMusicPlayerScreen() {
    Image(painter = painterResource(id = R.drawable.ic_arrow_down_small), contentDescription = null)
    Image(painter = painterResource(id = R.drawable.ic_music_player_option), contentDescription = null)
}