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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer.R
import com.example.navigationdrawer.data.list5
import com.example.navigationdrawer.ui.theme.OffWhite
import com.example.navigationdrawer.ui.theme.TopBackgroundColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSample6(){
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Open)
    var selectedIndex by remember { mutableIntStateOf(0) }
    val scope= rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet (
                drawerState=drawerState,
                modifier = Modifier.width(300.dp),
                drawerShape = RoundedCornerShape(12.dp),
                drawerTonalElevation = 16.dp
            ) {
                Column(modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .background(
                        brush = Brush.verticalGradient(
                            colorStops = arrayOf(
                                0.0f to TopBackgroundColor,
                                0.25f to TopBackgroundColor,
                                0.2f to Color.White,
                                1.0f to Color.White
                            )
                        )
                    )

                ) {
                    Column (
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
                    ){
                        Image(
                            painter = painterResource(R.drawable.hand_picking_camera),
                            contentDescription = null,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Ana Skulj",
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(top = 20.dp),
                            fontWeight = FontWeight.Medium,
                        )
                        Row (modifier = Modifier.padding(top = 5.dp)){
                            Text(
                                text = "265 Followers",
                                color = Color.White,
                                fontSize = 12.sp
                            )
                            Icon(
                                imageVector = Icons.Default.People,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.padding(start = 5.dp).size(14.dp)
                            )
                        }
                    }
                    list5.forEachIndexed { index, item1 ->
                        val isSelected=selectedIndex==index
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = item1.label,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },
                            selected = isSelected,
                            onClick = {
                                selectedIndex=index
                            },
                            modifier = Modifier
                                .padding(paddingValues = NavigationDrawerItemDefaults.ItemPadding)
                                .padding(bottom = if(index==6) 40.dp else 0.dp),
                            icon = {
                                Box(
                                    modifier = Modifier.size(30.dp)
                                ){
                                    Icon(
                                        imageVector = item1.vector,
                                        contentDescription = null,
                                        modifier = Modifier.align(alignment = Alignment.Center)
                                    )
                                    if(item1.hasBadge) {
                                        Box(
                                            modifier = Modifier
                                                .size(6.dp)
                                                .offset(x = (-1).dp, y = 2.dp)
                                                .align(Alignment.TopEnd)
                                                .clip(CircleShape)
                                                .background(color = TopBackgroundColor)
                                        )
                                    }
                                }
                            },
                            shape = RectangleShape,
                            colors = NavigationDrawerItemDefaults.colors(
                                selectedContainerColor = OffWhite,
                                unselectedContainerColor = Color.Transparent,
                                selectedIconColor = TopBackgroundColor,
                                unselectedIconColor = Color.LightGray,
                                selectedTextColor = TopBackgroundColor,
                                unselectedTextColor = Color.Black
                            )

                        )
                        if(index==6){
                            HorizontalDivider(Modifier.width(270.dp).align(Alignment.CenterHorizontally))
                        }
                    }
                }
            }
        },
        drawerState=drawerState
    ) {
        Scaffold (
            topBar = {
                TopAppBar(
                    title ={
                        Text(
                            text = "App bar title"
                        )
                    },
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
            Surface (modifier = Modifier.padding(innerPadding)){

            }
        }
    }
}

@Preview
@Composable
fun PreviewSample(){
    CustomSample3()
}