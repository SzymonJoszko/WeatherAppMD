package com.example.weatherappmd.Model

import com.google.gson.annotations.SerializedName

class WeatherDataResponse {
    @SerializedName("cod")
    var cod: Int = -1
    @SerializedName("weather")
    var weather: Array<WeatherResponse> = emptyArray()
    @SerializedName("main")
    var main: MainResponse = MainResponse()
    @SerializedName("dt")
    var dt: Int = 0
    @SerializedName("sys")
    var sys: SysResponse = SysResponse()
    @SerializedName("timezone")
    var timezone: Int = 0
}