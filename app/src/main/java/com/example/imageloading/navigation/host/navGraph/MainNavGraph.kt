package com.example.imageloading.navigation.host.navGraph

import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.imageloading.di.DaggerApiComponent
import com.example.imageloading.navigation.MAIN_ROUTE
import com.example.imageloading.navigation.Screen
import com.example.imageloading.screen.mainScreen.CoilScreen
import com.example.imageloading.screen.mainScreen.GlideScreen
import com.example.imageloading.screen.mainScreen.MainScreen
import com.example.imageloading.screen.mainScreen.PicassoScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavController,
    owner: LifecycleOwner
) {
    val apiComponent = DaggerApiComponent.create()
    navigation(
        startDestination = Screen.MainScreen.route,
        route = MAIN_ROUTE,
        builder = {
            composable(Screen.MainScreen.route){
                MainScreen(navController)
            }
            composable(Screen.ColiScreen.route){
                CoilScreen(
                    apiComponent.apiViewModel(),
                    owner
                )
            }
            composable(Screen.FrescoScreen.route){

            }
            composable(Screen.PicassoScreen.route){
                PicassoScreen(
                    apiComponent.apiViewModel(),
                    owner
                )
            }
            composable(Screen.GlideScreen.route){
                GlideScreen(
                    apiComponent.apiViewModel(),
                    owner
                )
            }
        }
    )
}