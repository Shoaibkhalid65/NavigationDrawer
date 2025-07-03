package com.example.navigationdrawer.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CloudSync
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PersonAddAlt1
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.SettingsVoice
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.VideoCameraFront
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.ui.theme.ContainerColor1
import com.example.navigationdrawer.ui.theme.SelectedItemColor

@Composable
fun CustomSample1(){
    val aiTools=listOf(
        "Video Creator" to Icons.Default.VideoCameraFront,
        "Text to Speech" to Icons.Default.TextFields,
        "Speech to Speech" to Icons.Default.Mic,
    )
    val aiCreations=listOf(
        "Avatar Creator" to Icons.Default.Brush,
        "Voice Cloning" to Icons.Default.CloudSync,
        "Request Twin Pro" to Icons.Default.PersonAddAlt1
    )
    val medias=listOf(
        "Recording History" to Icons.Default.History,
        "Voice Libraries" to Icons.Default.SettingsVoice,
        "Visual Gallery" to Icons.Default.Photo
    )
    var selectedIcon by remember { mutableStateOf(Icons.Default.Home) }
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
          drawerContent = {
              ModalDrawerSheet(
                  drawerState=drawerState,
                  modifier = Modifier.width(300.dp),
                  drawerShape = RoundedCornerShape(12.dp),
                  drawerContainerColor = ContainerColor1,
                  drawerTonalElevation = 16.dp,
                  drawerContentColor = Color.White,
              ) {
                  Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                      NavigationDrawerItem(
                          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding).padding(top = 20.dp),
                          label = {
                              Text(
                                  text = "Home"
                              )
                          },
                          selected = selectedIcon== Icons.Default.Home,
                          onClick = {
                              selectedIcon = Icons.Default.Home
                          },
                          icon = {
                              Icon(
                                  imageVector = Icons.Default.Home,
                                  contentDescription = null
                              )
                          },
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
                      Spacer(modifier = Modifier.height(20.dp))
                      Text(
                          text = "AI Tools",
                          color = Color.LightGray,
                          modifier = Modifier.padding(start = 30.dp)
                      )
                      Spacer(modifier = Modifier.height(10.dp))
                      aiTools.forEach { (label,vector)->
                          NavigationDrawerItem(
                              modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                              label = {
                                  Text(
                                      text = label
                                  )
                              },
                              selected = selectedIcon == vector,
                              onClick = {
                                  selectedIcon=vector
                              },
                              icon = {
                                  Icon(
                                      imageVector = vector,
                                      contentDescription = null
                                  )
                              },
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
                      Spacer(modifier = Modifier.height(20.dp))
                      Text(
                          text = "AI Creation",
                          color = Color.LightGray,
                          modifier = Modifier.padding(start = 30.dp)
                      )
                      Spacer(modifier = Modifier.height(10.dp))
                      aiCreations.forEach { (label,vector)->
                          NavigationDrawerItem(
                              modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                              label = {
                                  Text(
                                      text = label
                                  )
                              },
                              selected = selectedIcon == vector,
                              onClick = {
                                  selectedIcon=vector
                              },
                              icon = {
                                  Icon(
                                      imageVector = vector,
                                      contentDescription = null
                                  )
                              },
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
                      Spacer(modifier = Modifier.height(20.dp))
                      Text(
                          text = "Media",
                          color = Color.LightGray,
                          modifier = Modifier.padding(start = 30.dp)
                      )
                      Spacer(modifier = Modifier.height(10.dp))

                      medias.forEach { (label,vector)->
                          NavigationDrawerItem(
                              modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                              label = {
                                  Text(
                                      text = label
                                  )
                              },
                              selected = selectedIcon == vector,
                              onClick = {
                                  selectedIcon=vector
                              },
                              icon = {
                                  Icon(
                                      imageVector = vector,
                                      contentDescription = null
                                  )
                              },
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
                      Spacer(modifier = Modifier.height(20.dp))
                      Text(
                          text = "For Developers",
                          color = Color.LightGray,
                          modifier = Modifier.padding(start = 30.dp)
                      )
                      Spacer(modifier = Modifier.height(10.dp))

                      NavigationDrawerItem(
                          modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding).padding(bottom = 20.dp),
                          label = {
                              Text(
                                  text = "API Keys"
                              )
                          },
                          selected = selectedIcon== Icons.Default.Key,
                          onClick = {
                              selectedIcon = Icons.Default.Key
                          },
                          icon = {
                              Icon(
                                  imageVector = Icons.Default.Key,
                                  contentDescription = null
                              )
                          },
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
          },
        drawerState=drawerState,
    ) {

    }
}