package com.example.navigationdrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
            CustomSample6()
        }
    }
}