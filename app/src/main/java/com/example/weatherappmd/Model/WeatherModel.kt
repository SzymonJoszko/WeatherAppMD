package com.example.weatherappmd.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDateTime

class WeatherModel {

    private val _description = MutableLiveData<String>()
    val description: LiveData<String>
        get() = _description

    private val _image = MutableLiveData<String>()
    val  image: LiveData<String>
        get() = _image

    private val _temperature = MutableLiveData<String>()
    val temperature: LiveData<String>
        get() = _temperature

    private val _pressure = MutableLiveData<String>()
    val  pressure: LiveData<String>
        get() = _pressure

    //Data time
    private val _dt = MutableLiveData<String>()
    val dt: LiveData<String>
        get() = _dt

    private val _sunrise = MutableLiveData<String>()
    val  sunrise: LiveData<String>
        get() = _sunrise

    private val _sunset = MutableLiveData<String>()
    val  sunset: LiveData<String>
        get() = _sunset

    init {
        // Example data
        _description.value = "Example data: please type the city."
        _image.value = "s02d"
        _temperature.value = "22,5"
        _pressure.value = "1000 hPa"
        _dt.value = "15:20 23.06.2020"
        _sunrise.value = "05:22"
        _sunset.value = "20:40"
    }

    fun cityNameApproved(cityName : String?){
        try {
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
                    if (response!!.isSuccessful){
                        weatherData = response!!.body()
                        if(weatherData.cod == 200)
                            weatherDataSetter(weatherData)
                    }else
                        _description.value = "City doesn't exist."
                }

                override fun onFailure(call: Call<WeatherDataResponse>?, t: Throwable?) {
                    _description.value = "Connection error."
                }
            })
        }catch (exception: Exception){
            if (exception.message == null)
                _description.value = "City can't be blank! Please type the city."
            else
                _description.value = "Error: " + exception.message

        }
    }

    private fun weatherDataSetter(weatherData: WeatherDataResponse){
        _description.value = weatherData.weather[0].main + ": " + weatherData.weather[0].description
        _image.value = "s" + weatherData.weather[0].icon
        _temperature.value = "%.1f".format(kelvinToCelsius(weatherData.main.temp))
        _pressure.value = weatherData.main.pressure.toString() + " hPa"
        // Konwersja z unix do utc
        val dt = java.text.SimpleDateFormat("HH:mm dd-MM-yyyy")
        val date = java.util.Date(weatherData.dt.toLong() * 1000)
        _dt.value = dt.format(date)
        val sun = java.text.SimpleDateFormat("HH:mm")
        date.time = weatherData.sys.sunrise.toLong() * 1000
        _sunrise.value = sun.format(date)
        date.time = weatherData.sys.sunset.toLong() * 1000
        _sunset.value = sun.format(date)
    }

    private fun kelvinToCelsius(temp: Float):Float{
        return temp - 273.15F
    }
}