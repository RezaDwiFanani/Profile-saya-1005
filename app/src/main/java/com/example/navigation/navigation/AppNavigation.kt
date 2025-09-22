package com.profileandroidstudio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.profileandroidstudio.ui.screens.Page1Screen
import com.profileandroidstudio.ui.screens.Page2Screen
import com.profileandroidstudio.ui.screens.Page3Screen

@Composable
fun NavigationManager(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavRoutes.Page1Screen.route) {
        composable(NavRoutes.Page1Screen.route) {
            Page1Screen(navController)
        }
        composable(NavRoutes.Page2Screen.route) {
            Page2Screen(navController)
        }
        composable(NavRoutes.Page3Screen.route) {
            Page3Screen(navController)
        }
    }
}
