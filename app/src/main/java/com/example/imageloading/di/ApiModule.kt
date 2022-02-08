package com.example.imageloading.di

import com.example.imageloading.api.AnimalApi
import com.example.imageloading.api.ApiRepository
import com.example.imageloading.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule {

    @Provides
    fun providerApi(
        animalApi: AnimalApi
    ) = ApiRepository(animalApi)

    @Provides
    fun providerRetrofit():AnimalApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(AnimalApi::class.java)
}