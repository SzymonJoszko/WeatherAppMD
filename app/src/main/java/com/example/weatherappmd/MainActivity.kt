package com.example.weatherappmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przypisanie stałych ikon do imageView
        imageViewThermometer.setImageResource(R.drawable.ic_wi_thermometer)
        imageViewCelsius.setImageResource(R.drawable.ic_wi_celsius)
        imageViewBarometer.setImageResource(R.drawable.ic_wi_barometer)
        imageViewSunrise.setImageResource(R.drawable.ic_wi_sunrise)
        imageViewSunset.setImageResource(R.drawable.ic_wi_sunset)
        imageViewTime2.setImageResource(R.drawable.ic_wi_time_2)

        // Przykładowa pogoda
        imageView.setImageResource(R.drawable.ic_wi_day_cloudy)
    }
}
