package com.example.politicalver3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            //.height(200.dp)
            //.background(Color.LightGray)
            .fillMaxWidth()
            .padding(vertical = 64.dp), contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Header", fontSize = 60.sp, modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit,
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp),
            ) {
                Icon(imageVector = item.icon, contentDescription = item.contentDescription)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    //modifier = Modifier.align(Alignment.CenterVertically)
                    modifier = Modifier.weight(1f), style = itemTextStyle

                )
            }
        }
    }

}

// the drawer TopBar should get the navController as a parameter ,
// and the composable screen function that it needs to draw after the drawer
@Composable
fun DrawerTopBar(navController: NavController, screen: @Composable (navController: NavController) -> Unit) {

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(

        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(onNavigationIconClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }

            })
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(items = listOf(
                MenuItem(
                    id = "swipe",
                    title = "Swipe",
                    contentDescription = "Go to Swipe screen",
                    icon = Icons.Default.Home
                ),
                MenuItem(
                    id = "settings",
                    title = "Settings",
                    contentDescription = "Go to Settings screen",
                    icon = Icons.Default.Settings
                ),
                MenuItem(
                    id = "profile",
                    title = "Profile",
                    contentDescription = "Go to profile screen",
                    icon = Icons.Default.Info
                ),
            ), onItemClick = {
                when (it.id) {
                    "swipe" -> {
                        navController.navigate(Screen.SwipeScreen.route)
                    }
                    "settings" -> {
                        navController.navigate(Screen.PreferenceScreen.route)
                    }
                    "profile" -> {
                        navController.navigate(Screen.CelebProfileScreen.route)
                    }
                }
            })

        }) {

        screen(navController = navController)

    }
}


@Preview (showBackground = true)
@Composable
fun DrawerHeaderPreview() {
    DrawerTopBar(navController = NavController(LocalContext.current) , screen = { navController ->
        // this is the screen that will be drawn after the drawer
        // swipe screen
        SwipeScreen(navController = navController)

    })
}