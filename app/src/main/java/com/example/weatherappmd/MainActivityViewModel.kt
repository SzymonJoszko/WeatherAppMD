package com.example.weatherappmd

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherappmd.Model.WeatherModel

class MainActivityViewModel : ViewModel() {

    private val model = WeatherModel()
    val description : LiveData<String>
        get() = model.description
    val image : LiveData<String>
        get() = model.image
    @Bindable
    val cityName = MutableLiveData<String>()

    fun cityNameApproved() = model.cityNameApproved(cityName.value)
}