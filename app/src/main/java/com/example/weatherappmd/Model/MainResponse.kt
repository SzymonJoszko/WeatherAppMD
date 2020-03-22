package com.example.weatherappmd.Model

import com.google.gson.annotations.SerializedName

class MainResponse {
    @SerializedName("temp")
    var temp: Float = 0.0F
    @SerializedName("pressure")
    var pressure: Int = 0
}