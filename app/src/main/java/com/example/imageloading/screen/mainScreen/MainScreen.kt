package com.example.imageloading.screen.mainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.imageloading.navigation.Screen

@Composable
fun MainScreen(
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(title = "Coil") {
            navController.navigate(Screen.ColiScreen.route)
        }

        Button(title = "Fresco") {
            navController.navigate(Screen.FrescoScreen.route)
        }

        Button(title = "Glide") {
            navController.navigate(Screen.GlideScreen.route)
        }

        Button(title = "Picasso") {
            navController.navigate(Screen.PicassoScreen.route)
        }
    }
}

@Composable
private fun Button(
    title:String,
    onClick:() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(15.dp)
    ) {
        Text(text = title)
    }
}