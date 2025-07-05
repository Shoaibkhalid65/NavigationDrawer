package com.example.navigationdrawer.animatedDrawer2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContent1(
    modifier: Modifier= Modifier,
    customDrawerState1: CustomDrawerState1,
    onNavigationIconClick:(CustomDrawerState1)-> Unit
){
    Scaffold (
        modifier=modifier
            .clickable(enabled = customDrawerState1== CustomDrawerState1.Opened){
                onNavigationIconClick(CustomDrawerState1.Closed)
            },

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Top bar title"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onNavigationIconClick(customDrawerState1.opposite())
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
            modifier= Modifier.fillMaxSize().background(Color.Magenta).padding(innerPadding),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Main Screen"
            )
        }

    }
}