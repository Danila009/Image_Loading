package com.example.imageloading.screen.mainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import com.example.imageloading.R
import com.example.imageloading.api.ApiViewModel
import com.example.imageloading.model.Animal
import com.example.imageloading.utils.Converters
import com.example.imageloading.utils.Converters.bitmapGlide

@Composable
fun GlideScreen(
    apiViewModel: ApiViewModel,
    owner: LifecycleOwner
) {
    val context = LocalContext.current
    val imageBitmap = Converters.toBitmap(R.drawable.photo)
    val animalList = remember { mutableStateOf(listOf<Animal>()) }

    apiViewModel.getAnimal()
    apiViewModel.animalRepository.observe(owner){
        animalList.value = it
    }

    LazyColumn(content = {
        items(animalList.value){
            val imageBitmapState = remember { mutableStateOf(imageBitmap) }

            bitmapGlide(
                it.image_link,
                context,
                imageBitmapState
            )

            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    bitmap = imageBitmapState.value.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.padding(30.dp)
                )
            }
        }
    })
}