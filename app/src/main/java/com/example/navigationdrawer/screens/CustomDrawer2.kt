package com.example.navigationdrawer.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.data.list1
import com.example.navigationdrawer.ui.theme.ContainerColor
import com.example.navigationdrawer.ui.theme.ContainerColor1
import com.example.navigationdrawer.ui.theme.SelectedItemColor
import java.nio.file.WatchEvent

@Composable
fun CustomSample2(){
    var selectedItem by remember { mutableStateOf(Icons.Default.Home) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerState=drawerState,
                modifier = Modifier.width(300.dp),
                drawerShape = RoundedCornerShape(12.dp),
                drawerContainerColor = ContainerColor1,
                drawerTonalElevation = 16.dp
            ){
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                list1.forEachIndexed { index,item->
                    if(item is String){
                        Text(
                            text = item,
                            color = Color.LightGray,
                            modifier = Modifier.padding(start = 30.dp, top = 20.dp, bottom = 10.dp)
                        )
                    }else if(item is Pair<*, *>){
                        val (label,vector)=item
                        val imageVector = vector as ImageVector
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = label as String
                                )
                            },
                            selected = selectedItem==imageVector,
                            onClick = {
                                selectedItem=imageVector
                            },
                            icon = {
                                Icon(
                                    imageVector=imageVector,
                                    contentDescription = null
                                )
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                                .padding(
                                    top = if(index==0) 20.dp else 0.dp ,
                                    bottom = if(index==list1.size-1) 20.dp else 0.dp
                                ),
                            colors = NavigationDrawerItemDefaults.colors(
                                unselectedContainerColor = Color.Transparent,
                                selectedContainerColor = SelectedItemColor,
                                selectedTextColor = Color.White,
                                unselectedTextColor = Color.White,
                                unselectedIconColor = Color.White,
                                selectedIconColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp)
                        )
                    }
                  }
                }
            }
        },
        modifier = Modifier,
        drawerState = drawerState,
        scrimColor = SelectedItemColor.copy(0.5f)
    ) { }
}