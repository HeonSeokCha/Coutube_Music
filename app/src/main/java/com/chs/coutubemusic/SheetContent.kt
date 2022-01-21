package com.chs.coutubemusic

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            .graphicsLayer(alpha = 1f - currentFraction)
            .noRippleClickable(
                onClick = onSheetClick,
                enabled = isCollapsed
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}

@Composable
fun RowScope.CollapsedMusicPlayerScreen() {
    Image(painter = painterResource(id = R.drawable.test2), contentDescription = null)
    IconButton(
        onClick = {},
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = null)
    }
    IconButton(
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