package com.example.navigationdrawer.animatedDrawer

import android.media.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Diamond
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavigationItem (
    val label:String,
    val vector: ImageVector
){
    HOME(
        label = "Home",
        vector = Icons.Default.Home
    ),
    PROFILE(
        label = "Profile",
        vector = Icons.Default.Person
    ),
    PREMIUM(
        label = "Premium",
        vector = Icons.Default.Diamond
    ),
    SETTINGS(
        label = "Settings",
        vector = Icons.Default.Settings
    )
}