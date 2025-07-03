package com.example.navigationdrawer.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Badge
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CardTravel
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.Brush
import androidx.compose.material.icons.outlined.CardTravel
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Image
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun PermanentDrawer1(){
    val list=listOf(
        Icons.Default.Home to Icons.Outlined.Home,
        Icons.Default.Search to Icons.Outlined.Search,
        Icons.AutoMirrored.Default.Send to Icons.AutoMirrored.Outlined.Send,
        Icons.Default.Image to Icons.Outlined.Image,
        Icons.Default.Badge to Icons.Outlined.Badge,
        Icons.Default.CardTravel to Icons.Outlined.CardTravel,
        Icons.Default.Brush to Icons.Outlined.Brush,
        Icons.Default.Settings to Icons.Outlined.Settings,
        Icons.AutoMirrored.Default.Send to Icons.AutoMirrored.Outlined.Send,
        Icons.Default.Image to Icons.Outlined.Image,
        Icons.Default.Badge to Icons.Outlined.Badge,
        Icons.Default.CardTravel to Icons.Outlined.CardTravel,
        Icons.Default.Brush to Icons.Outlined.Brush,
        Icons.Default.Settings to Icons.Outlined.Settings
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(
                modifier = Modifier.width(250.dp),
                drawerShape = RoundedCornerShape(12.dp),
                drawerContainerColor = Color.Cyan,
                drawerContentColor = Color.Green,
                drawerTonalElevation = 24.dp,
                windowInsets = DrawerDefaults.windowInsets
            ) {
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    list.forEachIndexed { index, (filledIcon, outLinedIcon) ->
                        val isSelected = selectedIndex == index
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = filledIcon.name.split(".")[1]
                                )
                            },
                            selected = isSelected,
                            onClick = {
                                selectedIndex = index
                            },
                            modifier = Modifier.width(250.dp),
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) filledIcon else outLinedIcon,
                                    contentDescription = null,
                                )
                            },
                            badge = {
                                Badge {
                                    Text(
                                        text = index.toString()
                                    )
                                }
                            },
                            shape = RectangleShape,
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Color.Green,
                                unselectedContainerColor = Color.Red,
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.Black
                            )
                        )
                    }
                }
            }
        }

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ){
            Text(
                text = "This is the implementation of permanent navigation drawer,this automatically always open"
            )
        }
    }
}