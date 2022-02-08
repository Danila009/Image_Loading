package com.example.imageloading.navigation.host

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.imageloading.navigation.MAIN_ROUTE
import com.example.imageloading.navigation.ROUTE
import com.example.imageloading.navigation.host.navGraph.mainNavGraph

@Composable
fun Host(
    navHostController: NavHostController,
    owner: LifecycleOwner
) {
    NavHost(
        navController = navHostController,
        startDestination = MAIN_ROUTE,
        route = ROUTE,
        builder = {
            mainNavGraph(
                navHostController,
                owner
            )
        }
    )
}