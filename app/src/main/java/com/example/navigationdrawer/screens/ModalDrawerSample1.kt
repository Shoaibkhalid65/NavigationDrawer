package com.example.navigationdrawer.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Headphones
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.JoinFull
import androidx.compose.material.icons.filled.Keyboard
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Outbox
import androidx.compose.material.icons.filled.PushPin
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material.icons.filled.Radio
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun ModalDrawer1(){
    val items=listOf(
        Icons.Default.AccountCircle,
        Icons.Default.Bookmarks,
        Icons.Default.CalendarMonth,
        Icons.Default.Dashboard,
        Icons.Default.Email,
        Icons.Default.Favorite,
        Icons.Default.Group,
        Icons.Default.Headphones,
        Icons.Default.Image,
        Icons.Default.JoinFull,
        Icons.Default.Keyboard,
        Icons.Default.Laptop,
        Icons.Default.Map,
        Icons.Default.Navigation,
        Icons.Default.Outbox,
        Icons.Default.PushPin,
        Icons.Default.QrCode,
        Icons.Default.Radio,
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope= rememberCoroutineScope()
    var selectedItem by remember { mutableStateOf(items[0]) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
               drawerState=drawerState,
                modifier = Modifier,
                drawerShape = RoundedCornerShape(12.dp),
                drawerContainerColor = Color.LightGray,
                drawerContentColor = Color.Green,
                drawerTonalElevation = 16.dp
            ) {
                Column (
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ){
                    Spacer(modifier = Modifier.height(10.dp))
                    items.forEach { item->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item.name
                                )
                            },
                            selected = item==selectedItem,
                            onClick = {
                                selectedItem=item
                            },
                            modifier = Modifier.padding(top = 10.dp).width(300.dp),
                            icon = {
                                Icon(
                                    imageVector = item,
                                    contentDescription = null
                                )
                            },
                            badge = {
                                Badge {
                                    Text(
                                        text = "5"
                                    )
                                }
                            },
                            shape = RoundedCornerShape(16.dp),
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = Color.Magenta,
                                unselectedContainerColor = Color.DarkGray,
                                selectedIconColor = Color.White,
                                unselectedIconColor = Color.Black,
                                selectedTextColor = Color.Green,
                                unselectedTextColor = Color.Red,
                                selectedBadgeColor = Color.Yellow,
                                unselectedBadgeColor = Color.Blue
                            )
                        )
                    }
                }
            }
        },
        modifier = Modifier,
        drawerState=drawerState,
        gesturesEnabled = true,
        scrimColor = Color.Black.copy(alpha = 0.5f),
    ) {
        Column (
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                if(drawerState.isOpen){
                    "swipe left to close it"
                }else{
                    "swipe right to open it"
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    scope.launch {
                        if(drawerState.isOpen){
                            drawerState.close()
                        }else{
                            drawerState.open()
                        }
                    }
                }
            ) {
                Text(
                    "Click"
                )
            }
        }
    }
}