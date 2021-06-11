package com.pratamawijaya.weather.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.pratamawijaya.weather.presentation.ui.base.LocationActivity
import com.pratamawijaya.weather.presentation.ui.screens.WeatherScreen
import com.pratamawijaya.weather.presentation.ui.theme.WeatherModularTheme

class WeatherActivity : LocationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherModularTheme {
                // A surface container using the 'background' color from the theme
                WeatherScreen()
            }
        }
    }

    override fun onLocationSuccess(cityName: String) {
        d { "city name $cityName" }
    }

    override fun onLocationFailure() {
        e { "fail get location" }
    }
}

@Composable
fun App() {
    
}