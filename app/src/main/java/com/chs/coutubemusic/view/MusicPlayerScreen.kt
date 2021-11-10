package com.chs.coutubemusic.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    }
}

@Composable
fun MusicPlayerAppBar() {

}

@Composable
fun MusicPlayerImage() {
    Box(
        Modifier
            .width(300.dp)
            .height(200.dp)
            .padding(start = 16.dp, end = 16.dp)
            .background(Color.Cyan)
    )
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
                    contentDescription = null
                )
            }

            Text(
                modifier = Modifier.width(250.dp),
                text = title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_thumb_up),
                    contentDescription = null
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
    Row {

    }
}


@Preview(showSystemUi = true)
@Composable
private fun PreviewScreen() {
    CoutubeMusicTheme {
        MusicPlayerTitle("Plenty original", "LowFidelity Lounge")
    }
}