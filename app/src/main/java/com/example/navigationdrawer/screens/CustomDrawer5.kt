package com.example.navigationdrawer.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer.R
import com.example.navigationdrawer.data.list4
import com.example.navigationdrawer.ui.theme.BadgeColor
import com.example.navigationdrawer.ui.theme.ItemTextColor
import com.example.navigationdrawer.ui.theme.OffWhite

@Composable
fun CustomSample5(){
    var selectedItem by remember { mutableStateOf(Icons.Outlined.Person) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                drawerState=drawerState,
                modifier = Modifier.width(300.dp),
                drawerShape = RoundedCornerShape(16.dp),
                drawerContainerColor = Color.White
            ) {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier.padding(start = 10.dp, top = 30.dp)
                    ) {
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = null
                            )
                        }
                        Text(
                            text = "Settings & Members",
                            modifier = Modifier.padding(start = 8.dp, top = 12.dp),
                            color = Color.Black,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row (
                        modifier = Modifier.padding(start = 20.dp, top = 50.dp)
                    ){
                        Card (
                            modifier = Modifier.size(40.dp),
                            shape = CircleShape
                        ) {
                            Image(
                                painter = painterResource(R.drawable.men_headshot),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center
                            )
                        }
                        Column (modifier = Modifier.padding(start = 15.dp)){
                             Text(
                                 text = "Dawid Pietrasiak",
                                 color = Color.Black,
                                 fontSize = 17.sp,
                                 fontWeight = FontWeight.Medium
                             )
                            Text(
                                text = "dawid@product.com",
                                color = Color.Gray,
                                fontSize = 15.sp,
                                modifier = Modifier.padding(top = 2.dp)
                            )
                        }

                    }
                    list4.forEachIndexed { index, model ->
                        Text(
                            text = model.title,
                            modifier = Modifier.padding(top = 40.dp, start = 20.dp, bottom = 10.dp),
                            color = ItemTextColor,
                            fontWeight = FontWeight.Medium
                        )
                        model.listOfItems.forEachIndexed { index, sample ->
                            val isSelected=selectedItem==sample.vector
                            NavigationDrawerItem(
                                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                                label = {
                                    Text(
                                        text = sample.label,
                                        fontWeight = FontWeight.Medium
                                    )
                                },
                                selected = isSelected,
                                onClick = {
                                    selectedItem=sample.vector
                                },
                                icon = {
                                    Icon(
                                        imageVector = sample.vector,
                                        contentDescription = null
                                    )
                                },
                                badge = {
                                    sample.badgeCount?.let {
                                        Badge(
                                            modifier = Modifier.size(30.dp),
                                            containerColor = BadgeColor,

                                            ) {
                                            Text(
                                                text = sample.badgeCount.toString(),
                                                color = Color.White,
                                                fontSize = 14.sp
                                            )
                                        }
                                    }
                                },
                                colors = NavigationDrawerItemDefaults.colors(
                                    selectedContainerColor = OffWhite,
                                    unselectedContainerColor = Color.Transparent,
                                    selectedIconColor = BadgeColor,
                                    unselectedIconColor = ItemTextColor,
                                    selectedTextColor = Color.Black,
                                    unselectedTextColor = ItemTextColor
                                ),
                                shape = RoundedCornerShape(2.dp)
                            )
                        }
                    }

                }
            }
        },
        modifier = Modifier,
        drawerState = drawerState
    ) { }
}

