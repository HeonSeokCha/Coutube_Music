package com.chs.coutubemusic.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chs.coutubemusic.BottomDrawerState
import com.chs.coutubemusic.R
import com.chs.coutubemusic.noRippleClickable
import com.chs.coutubemusic.ui.theme.ChipDisableColor
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme

@Composable
fun MusicPlayerScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MusicPlayerImage()
        MusicPlayerTitle(title = "ABC", subTitle = "HyeonSeok")
        MusicPlayerControl()
    }
}

@Composable
fun MusicPlayerImage() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(280.dp)
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 8.dp,
                bottom = 8.dp
            )
            .clip(RoundedCornerShape(15f))
    ) {
        Image(
            painterResource(
                id = R.drawable.test2
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillHeight
        )
    }
}

@Composable
fun MusicPlayerTitle(
    title: String,
    subTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 8.dp,
                bottom = 8.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumb_down),
                    contentDescription = null,
                )
            }

            Text(
                modifier = Modifier.width(250.dp),
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumb_up),
                    contentDescription = null,
                )
            }
        }

        Text(
            text = subTitle,
            fontSize = 14.sp,
            color = Color.LightGray
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun testA(
    closeClick: () -> Unit,
    enabled: Boolean,
) {
    CollapsedMusicPlayer()
    ExpandMusicPlayerTopBar(closeClick, enabled)
}

@Composable
fun CollapsedMusicPlayer() {
    Image(
        modifier = Modifier
            .layoutId("music_pic"),
        painter = painterResource(id = R.drawable.test2),
        contentScale = ContentScale.Inside,
        contentDescription = null
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .layoutId("box"),
    ) {
        Column {
            Text(
                text = "Runaway",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Krewella",
                fontSize = 12.sp,
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_play),
            contentDescription = null
        )

        Image(
            painter = painterResource(id = R.drawable.ic_play_next),
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandMusicPlayerTopBar(
    closeClick: ()-> Unit,
    enabled: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
            .layoutId("btn_close"),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .noRippleClickable {
                    closeClick()
                    Log.e("Click", enabled.toString())
                },
            painter = painterResource(id = R.drawable.ic_arrow_down_small),
            contentDescription = null,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_music_player_option),
            contentDescription = null
        )
    }
}


@Composable
fun MusicPlayerControl() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 8.dp,
                bottom = 8.dp
            )
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray,
            progress = 0f
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = "0:00",
                fontSize = 12.sp,
                color = Color.LightGray
            )

            Text(
                text = "4:39",
                fontSize = 12.sp,
                color = Color.LightGray
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_shuffle),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_previous),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(64.dp)
                    .background(
                        shape = CircleShape,
                        color = ChipDisableColor,
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_next),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_repeat),
                    contentDescription = null,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewScreen() {
    CoutubeMusicTheme {
        MusicPlayerScreen(rememberNavController())
    }
}