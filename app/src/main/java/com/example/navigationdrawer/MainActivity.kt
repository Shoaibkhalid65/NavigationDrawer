package com.example.navigationdrawer

import MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.navigationdrawer.animatedDrawer1.BodyContent
import com.example.navigationdrawer.animatedDrawer1.NavigationDrawer
import com.example.navigationdrawer.animatedDrawer2.MainScreen1
import com.example.navigationdrawer.animatedDrawer2.MainScreen2
import com.example.navigationdrawer.animatedDrawer2.MainScreen3

import com.example.navigationdrawer.screens.CustomSample1
import com.example.navigationdrawer.screens.CustomSample2
import com.example.navigationdrawer.screens.CustomSample3
import com.example.navigationdrawer.screens.CustomSample4
import com.example.navigationdrawer.screens.CustomSample5
import com.example.navigationdrawer.screens.CustomSample6

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen3()

        }
    }
}