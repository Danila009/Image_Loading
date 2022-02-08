package com.example.imageloading.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.imageloading.R
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception

object Converters {

    @Composable
    fun toBitmap(int: Int):Bitmap{
        val context = LocalContext.current
        return BitmapFactory.decodeResource(
            context.resources,
            int
        )
    }

    suspend fun bitmapCoil(
        url:String,
        context: Context
    ):Bitmap{
        val loading = ImageLoader(context)
        val request = ImageRequest.Builder(context)
            .data(url)
            .build()

        val result = (loading.execute(request) as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }

    fun bitmapGlide(
        url:String,
        context: Context,
        bitmap:MutableState<Bitmap>
    ){
        Glide.with(context)
            .asBitmap()
            .load(url)
            .error(R.drawable.photo)
            .into(object : CustomTarget<Bitmap>(){
                override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                    bitmap.value = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    TODO()
                }
            })
    }

    fun bitmapPicasso(
        url:String,
        bitmap: MutableState<Bitmap>,
        context: Context
    ){
        Picasso.get()
            .load(url)
            .placeholder(R.drawable.photo)
            .error(R.drawable.photo)
            .into(object : Target{
                override fun onBitmapLoaded(bitmapImage: Bitmap?, from: Picasso.LoadedFrom?) {
                    bitmapImage?.let {
                        bitmap.value = it
                    }
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    TODO("Not yet implemented")
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
                    TODO("Not yet implemented")
                }
            })
    }
}