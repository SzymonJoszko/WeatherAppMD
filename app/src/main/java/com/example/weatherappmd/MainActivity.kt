package com.example.weatherappmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setImageResource(R.drawable.ic_wi_day_cloudy)
        imageViewThermometer.setImageResource(R.drawable.ic_wi_thermometer)
        imageViewCelsius.setImageResource(R.drawable.ic_wi_celsius)
        imageViewBarometer.setImageResource(R.drawable.ic_wi_barometer)
    }
}
