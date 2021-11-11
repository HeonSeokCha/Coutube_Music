package com.chs.coutubemusic.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chs.coutubemusic.R
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme

@Composable
fun MusicPLayerScreen() {
    Column {
        MusicPlayerImage()
        Spacer(modifier = Modifier.padding(top = 8.dp,bottom = 8.dp))
        MusicPlayerTitle(title = "ABC", subTitle = "HyeonSeok")
        Spacer(modifier = Modifier.padding(top = 8.dp,bottom = 8.dp))
        MusicPlayerControl()
    }
}

@Composable
fun MusicPlayerAppBar() {

}

@Composable
fun MusicPlayerImage() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(start = 24.dp, end = 24.dp)
            .clip(RoundedCornerShape(15f))
    ) {
        Image(painterResource(
            id = R.drawable.test),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
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
            .padding(start = 24.dp, end = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumb_down),
                    contentDescription = null,
                    Modifier.size(16.dp)
                )
            }

            Text(
                modifier = Modifier.width(250.dp),
                text = title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumb_up),
                    contentDescription = null,
                    Modifier.size(16.dp)
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


@Composable
fun MusicPlayerControl() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(start = 24.dp, end = 24.dp)) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = Color.LightGray
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
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_shuffle),
                    contentDescription = null
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_previous),
                    contentDescription = null
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = null
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play_next),
                    contentDescription = null
                )
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_repeat),
                    contentDescription = null
                )
            }
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PreviewScreen() {
    CoutubeMusicTheme {
        Column {
            MusicPlayerImage()
            Spacer(modifier = Modifier.padding(top = 8.dp,bottom = 8.dp))
            MusicPlayerTitle(title = "ABC", subTitle = "HyeonSeok")
            Spacer(modifier = Modifier.padding(top = 8.dp,bottom = 8.dp))
            MusicPlayerControl()
        }
    }
}