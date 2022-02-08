package com.example.imageloading.api

import com.example.imageloading.model.Animal
import com.example.imageloading.utils.Constants.GET_ANIMAL
import retrofit2.Response
import retrofit2.http.GET

interface AnimalApi {

    @GET(GET_ANIMAL)
    suspend fun getAnimal():Response<List<Animal>>
}