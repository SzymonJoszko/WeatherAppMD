package com.example.weatherappmd.Model

import com.google.gson.annotations.SerializedName

class WeatherResponse {
    @SerializedName("main")
    var main: String = "No data"
    @SerializedName("description")
    var description = "No data"
    @SerializedName("icon")
    var icon: String = "ic_wi_alien"
}