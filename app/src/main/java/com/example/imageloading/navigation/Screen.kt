package com.example.imageloading.navigation

const val ROUTE = "route"
const val MAIN_ROUTE = "main_route"

sealed class Screen(val route:String){
    object MainScreen:Screen("main")
    object ColiScreen:Screen("coil")
    object PicassoScreen:Screen("picasso")
    object GlideScreen:Screen("glide")
    object FrescoScreen:Screen("fresco")
}
