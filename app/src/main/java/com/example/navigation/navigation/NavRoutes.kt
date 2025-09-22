package com.profileandroidstudio.navigation

sealed class NavRoutes(val route: String) {
    object Page1Screen : NavRoutes("page1")
    object Page2Screen : NavRoutes("page2")
    object Page3Screen : NavRoutes("page3")
}
