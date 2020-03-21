package com.example.weatherappmd.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class WeatherModel {
    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    init {
        _description.value = "to jest opis"
    }
}