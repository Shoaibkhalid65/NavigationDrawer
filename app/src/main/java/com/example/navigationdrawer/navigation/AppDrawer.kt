package com.example.navigationdrawer.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawerSample(navController: NavHostController){
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope ()
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerState=drawerState,
                modifier = Modifier.width(250.dp)
            ){
               Destination.entries.forEachIndexed { index, destination ->
                   val isSelected=selectedIndex==index
                   NavigationDrawerItem(
                       label = {
                           Text(
                               text = destination.label
                           )
                       },
                       selected = isSelected,
                       onClick = {
                           selectedIndex=index
                           navController.navigate(destination.route)
                           scope.launch {
                               drawerState.close()
                           }
                       },
                       modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                       icon = {
                           Icon(
                               imageVector = if(isSelected) destination.filledVector else destination.outlinedVector,
                               contentDescription = null
                           )
                       },
                       badge = {
                           destination.badgeCount?.let {
                               Text(
                                   text = destination.badgeCount.toString()
                               )
                           }
                       }
                   )
               }
            }
        },
        drawerState = drawerState,
        gesturesEnabled = true,
        scrimColor = Color.Yellow.copy(0.5f)
    ) {
        Scaffold (
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Top bar title"
                        )
                    },
                    modifier = Modifier,
                    navigationIcon = {
                        IconButton(
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
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = null
                            )
                        }
                    }
                )
            }
        ){ innerPadding->
            Box(
                modifier = Modifier.padding(innerPadding),
                contentAlignment = Alignment.Center

            ){
//                Text(
//                    text = "Main Screen"
//                )
                AppNavHost(navController, Destination.HOME)
            }

        }
    }
}