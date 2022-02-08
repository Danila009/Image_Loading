package com.example.imageloading.api

import com.example.imageloading.model.Animal
import retrofit2.Response
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val animalApi: AnimalApi
):AnimalApi {
    override suspend fun getAnimal():Response<List<Animal>> = animalApi.getAnimal()
}