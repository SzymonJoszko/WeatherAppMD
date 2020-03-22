package com.example.weatherappmd.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WeatherModel {

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _image = MutableLiveData<String>()
    val  image: LiveData<String>
        get() = _image

    init {
        _description.value = "to jest opis"
        _image.value = "02d"
    }

    fun cityNameApproved(cityName : String?){
        _description.value = cityName
        _image.value = cityName
    }
}