package com.example.navigationdrawer.animatedDrawer2

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.data.list6


@Composable
fun CustomDrawer1(onCloseClick:()-> Unit){
    var selectedIndex by remember { mutableIntStateOf(0) }
    ModalDrawerSheet(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(fraction = 0.6f)
    ) {
        IconButton(
            onClick = {
                onCloseClick()
            }
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
        list6.forEachIndexed { index, (label,vector) ->
            val isSelected=selectedIndex==index
            NavigationDrawerItem(
                label = {
                    Text(
                        text = label
                    )
                },
                selected = isSelected,
                onClick = {
                    selectedIndex=index
                },
                icon = {
                    Icon(
                        imageVector = vector,
                        contentDescription = null
                    )
                }
            )
        }
    }
}