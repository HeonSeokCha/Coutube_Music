package com.chs.coutubemusic.view

import android.graphics.drawable.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chs.coutubemusic.R
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme

@Composable
fun ExploreScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn {
            items(3) {
                ExploreTopItem(title = "새 앨범", image = Icons.Default.PlayArrow)
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
fun ExploreTopItem(title: String, image: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(imageVector = image, contentDescription = null)
        Text (
            text = title,
            fontSize = 22.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
    }

}

@Preview(showBackground = true)
@Composable
fun testExplore() {
    CoutubeMusicTheme {
        ExploreTopItem("새 얼범", image = Icons.Default.PlayArrow)
    }
}