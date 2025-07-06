package com.example.navigationdrawer.animatedDrawer3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationdrawer.R
import com.example.navigationdrawer.ui.theme.DrawerContainerColor1
import com.example.navigationdrawer.ui.theme.DrawerPinkColor
import com.example.navigationdrawer.ui.theme.DrawerSelectedItemColor1
import com.example.navigationdrawer.ui.theme.DrawerTextColor

@Composable
fun CustomDrawer(){
    var selectedItem by remember { mutableStateOf("DashBoard") }
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.65f),
        drawerShape = RoundedCornerShape(16.dp),
        drawerContainerColor = DrawerContainerColor1,
        drawerContentColor = DrawerSelectedItemColor1,
        drawerTonalElevation = 16.dp
    ) {
        Row (
            modifier = Modifier.padding(vertical = 30.dp, horizontal = 20.dp)
        ){
            Image(
                painter = painterResource(R.drawable.man_avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .background(
                        color = DrawerPinkColor,
                        shape = CircleShape
                    )
                    .clip(CircleShape)
            )
            Column (
                modifier = Modifier.padding(start = 10.dp, top = 5.dp)
            ){
                Text(
                    text = "PRODUCT MANAGER",
                    color = DrawerTextColor,
                    fontSize = 13.sp,
                )
                Text(
                    text = "Andrew Smith",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 5.dp),
                    fontWeight = FontWeight.Medium
                )
            }
        }
        CustomHorizontalDivider()
        DrawerItem.entries.forEachIndexed {parentIndex,drawerItem ->
            Text(
                text = drawerItem.title,
                color = DrawerTextColor,
                fontSize = 13.sp,
                modifier = Modifier.padding(start = 27.dp, top = 30.dp, bottom = 10.dp)
            )
            drawerItem.items.forEachIndexed { childIndex, sampleItem ->
                val isSelected=selectedItem==sampleItem.label
                val isLogOutItem=parentIndex==1&&childIndex==2
                val color=when{
                    isLogOutItem->DrawerPinkColor
                    isSelected->Color.White
                    else->DrawerTextColor
                }
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = sampleItem.label,
                            color = color
                        )
                    },
                    selected = isSelected,
                    onClick = {
                        selectedItem=sampleItem.label
                    },
                    icon = {
                        Icon(
                            painter = painterResource(sampleItem.iconId),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = color
                        )
                    },
                    badge = {
                        if(sampleItem.hasBadgeIcon){
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = null,
                                tint = DrawerTextColor
                            )
                        }
                    },
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedContainerColor =  DrawerSelectedItemColor1,
                        unselectedContainerColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.padding(
                        paddingValues = NavigationDrawerItemDefaults.ItemPadding
                    )
                )
                if(parentIndex==1&&childIndex==0){
                    Spacer(modifier = Modifier.height(180.dp))
                }
            }
            if(parentIndex==0) {
                Spacer(modifier = Modifier.height(20.dp))
                CustomHorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
fun DrawerPreview(){
    CustomDrawer()
}

@Composable
fun CustomHorizontalDivider(){
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.Center),
            thickness = 2.dp,
            color = DrawerSelectedItemColor1
        )
    }
}