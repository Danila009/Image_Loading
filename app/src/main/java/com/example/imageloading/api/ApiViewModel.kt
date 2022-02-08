package com.example.imageloading.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imageloading.model.Animal
import kotlinx.coroutines.launch
import javax.inject.Inject

class ApiViewModel @Inject constructor(
    private val repository: ApiRepository
):ViewModel() {

    val animalRepository:MutableLiveData<List<Animal>> = MutableLiveData()

    fun getAnimal(){
        viewModelScope.launch {
            animalRepository.value = repository.getAnimal().body()
        }
    }
}