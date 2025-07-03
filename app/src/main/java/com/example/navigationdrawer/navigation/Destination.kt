package com.example.navigationdrawer.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination (
    val route: String,
    val outlinedVector: ImageVector,
    val filledVector: ImageVector,
    val label: String,
    val badgeCount: Int?=null
){
    HOME(
        route = "home_route",
        outlinedVector = Icons.Outlined.Home,
        filledVector = Icons.Filled.Home,
        label = "Home",
        badgeCount = 25
    ),
    SEARCH(
        route = "search_route",
        outlinedVector = Icons.Outlined.Search,
        filledVector = Icons.Filled.Search,
        label = "Search"
    ),
    PROFILE(
        route = "profile_route",
        outlinedVector = Icons.Outlined.Person,
        filledVector = Icons.Filled.Person,
        label = "Profile",
        badgeCount = 10
    ),
    SETTING(
        route = "setting_route",
        outlinedVector = Icons.Outlined.Settings,
        filledVector = Icons.Filled.Settings,
        label = "Setting",
        badgeCount = 5
    )
}