package com.example.weatherappmd

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappmd.Model.WeatherModel

class MainActivityViewModel : ViewModel() {
    private val model = WeatherModel()
    val description : LiveData<String>
        get() = model.description
}