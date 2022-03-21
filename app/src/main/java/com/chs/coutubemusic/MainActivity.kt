package com.chs.coutubemusic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.twotone.PlayArrow
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material.icons.twotone.Share
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ExperimentalMotionApi
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.chs.coutubemusic.navigation.SetUpNavGraph
import com.chs.coutubemusic.ui.theme.BottomBarColor
import com.chs.coutubemusic.ui.theme.CoutubeMusicTheme
import com.chs.coutubemusic.view.MusicPlayerScreen
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    @OptIn(ExperimentalMotionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scope = rememberCoroutineScope()
            val (canPop, setCanPop) = remember { mutableStateOf(false) }
            val scaffoldState = rememberBottomDrawerScaffoldState(
              bottomDrawerState   = rememberBottomDrawerState(
                  initialValue = BottomDrawerValue.Collapsed,
                  drawerTopInset = 0
              )
            )

            val context = LocalContext.current
            val motionScene = remember {
                context.resources
                    .openRawResource(R.raw.motion_scene)
                    .readBytes()
                    .decodeToString()
            }

            val sheetToggle: () -> Unit = {
                scope.launch {
                    if (scaffoldState.bottomDrawerState.isCollapsed) {
                        scaffoldState.bottomDrawerState.expand()
                    } else {
                        scaffoldState.bottomDrawerState.collapse()
                    }
                }
            }

            navController = rememberNavController()
            navController.addOnDestinationChangedListener { controller, _, _ ->
                setCanPop(controller.previousBackStackEntry != null)
            }
            CoutubeMusicTheme {
                BottomBarScaffold(
                    topBar = {
                         Appbar(canPop, navController)
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
                                if (it.route != navController.currentDestination?.route) {
                                    navController.navigate(it.route) {
                                        popUpTo(0)
                                        launchSingleTop = true
                                    }
                                }
                            }
                        )
                    },
                    scaffoldState = scaffoldState,
                    drawerModifier = Modifier,
                    drawerGesturesEnabled = true,
                    drawerPeekHeight = 125.dp,
                    drawerElevation = 0.dp,
                    drawerContent = {
                        MotionLayout(
                            motionScene = MotionScene(content = motionScene),
                            progress = scaffoldState.currentFraction,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Image(
                                modifier = Modifier
                                    .padding(start = 8.dp)
                                    .layoutId("music_pic"),
                                painter = painterResource(id = R.drawable.test2),
                                contentScale = ContentScale.Crop,
                                contentDescription = null
                            )
                            Text(
                                modifier = Modifier.layoutId("music_title"),
                                text = "Runaway",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                modifier = Modifier.layoutId("music_sub_title"),
                                text = "Krewella",
                                fontSize = 12.sp,
                            )

                            Image(
                                modifier = Modifier.layoutId("music_play_btn"),
                                painter = painterResource(id = R.drawable.ic_play),
                                contentDescription = null
                            )

                            Image(
                                modifier = Modifier.layoutId("music_next_btn"),
                                painter = painterResource(id = R.drawable.ic_play_next),
                                contentDescription = null
                            )

                        }
                    },
                    content = {
                        SetUpNavGraph(bottomNavController = navController, paddingValues = it)
                    }
                )
            }
        }
    }
}

@Composable
fun Appbar(
    canPop: Boolean,
    navController: NavHostController
) {
    Column {
        if (canPop) {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            )
        } else {
            TopAppBar(
                title = {
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
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            )
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

@ExperimentalMaterialApi
val BottomDrawerScaffoldState.currentFraction: Float
    get() {
        val fraction = bottomDrawerState.progress.fraction
        val targetValue = bottomDrawerState.targetValue
        val currentValue = bottomDrawerState.currentValue

        return when {
            currentValue == BottomDrawerValue.Collapsed && targetValue == BottomDrawerValue.Collapsed -> 0f
            currentValue == BottomDrawerValue.Expanded && targetValue == BottomDrawerValue.Expanded -> 1f
            currentValue == BottomDrawerValue.Collapsed && targetValue == BottomDrawerValue.Expanded -> fraction
            else -> 1f - fraction
        }
    }