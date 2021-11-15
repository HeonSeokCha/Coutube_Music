package com.chs.coutubemusic.view

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chs.coutubemusic.R
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme

@Composable
fun ExploreScreen(navController: NavHostController) {
    val exploreTopItems: List<Pair<String, Painter>> = listOf(
        "새 앨범" to painterResource(id = R.drawable.ic_new_album),
        "차트" to painterResource(id = R.drawable.ic_chart),
        "분위기 및 장르" to painterResource(id = R.drawable.ic_feel),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn {
            items(3) { idx ->
                ExploreTopItem(exploreTopItems[idx])
            }
            item {
                Spacer(modifier = Modifier.padding(bottom = 16.dp))
                HorizontalAlbum(
                    navController = navController,
                    title = "새 앨범 및 싱글"
                )
            }
        }
    }
}

@Composable
fun ExploreTopItem(item: Pair<String, Painter>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = item.second,
            contentDescription = null,
        )
        Text(
            text = item.first,
            fontSize = 22.sp,
            color = Color.White,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun testExplore() {
    CoutubeMusicTheme {
    }
}