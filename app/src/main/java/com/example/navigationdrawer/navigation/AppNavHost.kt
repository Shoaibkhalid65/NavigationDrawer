package com.example.navigationdrawer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    startDestination: Destination
){
    NavHost(
        navController = navHostController,
        startDestination = startDestination.route
    ){
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when(destination){
                    Destination.HOME -> HomeScreen()
                    Destination.SEARCH -> SearchScreen()
                    Destination.PROFILE -> ProfileScreen()
                    Destination.SETTING -> SettingScreen()
                }
            }
        }
    }
}