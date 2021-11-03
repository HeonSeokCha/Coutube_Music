package com.chs.coutubemusic

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material.icons.twotone.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chs.coutubemusic.ui.theme.BottomBarColor
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme
import com.chs.coutubemusic.view.ExploreScreen
import com.chs.coutubemusic.view.HomeScreen
import com.chs.coutubemusic.view.LibraryScreen
import java.nio.file.Files.size

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoutubeMusicTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        Appbar()
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            items = listOf(
                                BottomNavItem(
                                    name = "Home",
                                    route = "home",
                                    icon = Icons.Default.Home
                                ),
                                BottomNavItem(
                                    name = "Explore",
                                    route = "explore",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_un_explore)
                                ),
                                BottomNavItem(
                                    name = "Library",
                                    route = "library",
                                    icon = ImageVector.vectorResource(id = R.drawable.ic_un_library)
                                )
                            ),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    }
                ) {
                    Navigation(navController = navController)
                }
            }
        }
    }
}

@Composable
fun Appbar() {
    Column {
        TopAppBar(title = {
            Icon(imageVector = Icons.TwoTone.PlayArrow, contentDescription = null)
            Text(text = "Music")
        },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.TwoTone.Share, contentDescription = null)
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.TwoTone.Search, contentDescription = null)
                }

                IconButton(onClick = { /*TODO*/ }) {
                    Image(
                        painter = painterResource(id = R.drawable.test),
                        contentDescription = null,
                    )
                }
            })
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("explore") {
            ExploreScreen()
        }
        composable("library") {
            LibraryScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = BottomBarColor,
        elevation = 5.dp
    ) {
        items.forEach { items ->
            val selected = items.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(items) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        Icon(
                            imageVector = items.icon,
                            contentDescription = null
                        )
                        Text(
                            text = items.name,
                            fontSize = 10.sp
                        )
                    }
                }
            )
        }
    }
}








@Preview(showBackground = true)
@Composable
fun PreviewAppBar() {
    CoutubeMusicTheme {
        val navController = rememberNavController()
        BottomNavigationBar(
            items = listOf(
                BottomNavItem(
                    name = "Home",
                    route = "home",
                    icon = Icons.Default.Home
                ),
                BottomNavItem(
                    name = "Explore",
                    route = "explore",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_un_explore)
                ),
                BottomNavItem(
                    name = "Library",
                    route = "library",
                    icon = ImageVector.vectorResource(id = R.drawable.ic_un_library)
                )
            ),
            navController = navController,
            onItemClick = {
                navController.navigate(it.route)
            }
        )
    }
}