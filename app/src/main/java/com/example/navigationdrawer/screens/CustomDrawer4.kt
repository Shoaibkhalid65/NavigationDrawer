package com.example.navigationdrawer.screens

import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.example.navigationdrawer.data.list3
import com.example.navigationdrawer.ui.theme.Container1
import com.example.navigationdrawer.ui.theme.IconColor
import com.example.navigationdrawer.ui.theme.SelectedItem

@Composable
fun CustomSample4(){
    var selectedIndex by remember { mutableIntStateOf(0)}
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet (
                drawerState=drawerState,
                drawerContainerColor = Container1,
                drawerShape = RectangleShape,
                modifier = Modifier.width(300.dp)
            ){
                list3.forEachIndexed { index, item ->
                    val isSelected=selectedIndex==index
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = item.label
                            )
                        },
                        selected = isSelected,
                        onClick ={
                            selectedIndex=index
                        },
                        icon = {
                            Icon(
                               imageVector = if(isSelected) item.filledVector else item.outlinedVector,
                                contentDescription = null
                            )
                        },
                        shape = RectangleShape,
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = SelectedItem,
                            unselectedContainerColor = Color.Transparent,
                            selectedIconColor = IconColor,
                            unselectedIconColor = Color.White,
                            selectedTextColor = IconColor,
                            unselectedTextColor = Color.White
                        ),
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                            .padding(top = if(index==0) 50.dp else 0.dp)

                    )
                }
            }
        },
        drawerState=drawerState

    ) { }
}