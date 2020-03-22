package com.example.weatherappmd.Model

import com.google.gson.annotations.SerializedName

class SysResponse {
    @SerializedName("country")
    var country: String = "No data"
    @SerializedName("sunrise")
    var sunrise: Int = 0
    @SerializedName("sunset")
    var sunset: Int = 0
}