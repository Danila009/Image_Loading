package com.example.imageloading.di

import com.example.imageloading.api.ApiViewModel
import dagger.Component

@Component(modules = [
    ApiModule::class
])
interface ApiComponent {

    fun apiViewModel():ApiViewModel
}