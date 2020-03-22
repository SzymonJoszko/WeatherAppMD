package com.example.weatherappmd.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherModel {

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _image = MutableLiveData<String>()
    val  image: LiveData<String>
        get() = _image

    private val _temperature = MutableLiveData<Float>()
    val temperature: LiveData<Float>
        get() = _temperature

    private val _pressure = MutableLiveData<Int>()
    val  pressure: LiveData<Int>
        get() = _pressure

    //Data time
    private val _dt = MutableLiveData<Int>()
    val dt: LiveData<Int>
        get() = _dt

    private val _sunrise = MutableLiveData<Int>()
    val  sunrise: LiveData<Int>
        get() = _sunrise

    private val _sunset = MutableLiveData<Int>()
    val  sunset: LiveData<Int>
        get() = _sunset

    init {
        _description.value = "to jest opis"
        _image.value = "02d"
    }

    fun cityNameApproved(cityName : String?){
        var weatherData: WeatherDataResponse = WeatherDataResponse()
        val url = "https://api.openweathermap.org/data/2.5/"
        val APIkey = "5cd4d74883f242b99280e32d2edd8dc1"
        val retrofit = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
        val services = retrofit.create(IWeatherDataServices::class.java)
        val call = services.getWeatherData(cityName!!, APIkey)

        call.enqueue(object :Callback<WeatherDataResponse>{

            override fun onResponse(
                call: Call<WeatherDataResponse>?,
                response: Response<WeatherDataResponse>?
            ) {
                weatherData = response!!.body()
                if(weatherData.cod == 200)
                    weatherDataSetter(weatherData)
            }

            override fun onFailure(call: Call<WeatherDataResponse>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun weatherDataSetter(weatherData: WeatherDataResponse){
        _description.value = weatherData.weather[0].main + ": " + weatherData.weather[0].description
        _image.value = weatherData.weather[0].icon
        _temperature.value = weatherData.main.temp
        _pressure.value = weatherData.main.pressure
        _dt.value = weatherData.dt
        _sunrise.value = weatherData.sys.sunrise
        _sunset.value = weatherData.sys .sunset
    }
}