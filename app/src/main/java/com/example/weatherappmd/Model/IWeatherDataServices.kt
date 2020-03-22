package com.example.weatherappmd.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IWeatherDataServices {
    @GET("weather")
    fun getWeatherData(@Query("q") cityName: String,
                       @Query("appid") APIkey: String) : Call<WeatherDataResponse>
}