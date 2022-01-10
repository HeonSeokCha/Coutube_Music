package com.chs.coutubemusic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    heightFraction: Float = 0.8f,
    content: @Composable BoxScope.() -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = heightFraction)
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
            .background(Color.Black)
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
            .background(Color.Black)
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
fun MusicPlayer(
    topSection: @Composable () -> Unit,
    playerControls: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(BottomBarColor)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 35.dp)
            ) {
                topSection()
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
        ) {
            Spacer(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            bottomStartPercent = 100,
                            bottomEndPercent = 100
                        )
                    )
                    .background(BottomBarColor)
                    .height(35.dp)
                    .fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 35.dp),
                contentAlignment = Alignment.Center
            ) {
                playerControls()
            }
        }
    }
}

@Composable
fun RowScope.MusicPlayerScreenSmall() {
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