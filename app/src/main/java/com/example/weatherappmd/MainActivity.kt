package com.example.weatherappmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.weatherappmd.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            this.setLifecycleOwner(this@MainActivity)
            this.viewmodel  = mainViewModel
        }

        // Zmiana ikonki pogody
        mainViewModel.image.observe(this, Observer {
            imageView.setImageResource(resources.getIdentifier(mainViewModel.image.value, "drawable", packageName))
        })

        // Przypisanie stałych ikon do imageView
        imageViewThermometer.setImageResource(R.drawable.ic_wi_thermometer)
        imageViewCelsius.setImageResource(R.drawable.ic_wi_celsius)
        imageViewBarometer.setImageResource(R.drawable.ic_wi_barometer)
        imageViewSunrise.setImageResource(R.drawable.ic_wi_sunrise)
        imageViewSunset.setImageResource(R.drawable.ic_wi_sunset)
        imageViewTime2.setImageResource(R.drawable.ic_wi_time_2)
    }
}
