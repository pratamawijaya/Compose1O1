package com.pratamawijaya.weather.presentation.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.ajalt.timberkt.d
import com.github.ajalt.timberkt.e
import com.pratamawijaya.weather.presentation.ui.base.LocationActivity
import com.pratamawijaya.weather.presentation.ui.home.components.WeatherScreen
import com.pratamawijaya.weather.presentation.ui.home.event.LocationViewEvent
import com.pratamawijaya.weather.presentation.ui.navigation.Destinations
import com.pratamawijaya.weather.presentation.ui.navigation.Navigations
import com.pratamawijaya.weather.presentation.ui.navigation.ProvideNavHosController
import com.pratamawijaya.weather.presentation.ui.theme.WeatherModularTheme

class WeatherActivity : LocationActivity() {

    private var weatherViewModel: WeatherViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherModularTheme {
                // A surface container using the 'background' color from the theme
                WeatherApp(onLocationRequested = { viewModel ->
                    if (viewModel == null)
                        weatherViewModel = viewModel

                    getLocation()
                })
            }
        }
    }

    override fun onLocationSuccess(cityName: String) {
        d { "city name $cityName" }
        weatherViewModel?.onLocationEvent(LocationViewEvent.SetLocation(cityName))
    }

    override fun onLocationFailure() {
        e { "fail get location" }
        weatherViewModel?.onLocationEvent(LocationViewEvent.LocationError)
    }
}

@Composable
fun WeatherApp(onLocationRequested: (WeatherViewModel) -> Unit = {}) {

    ProvideNavHosController {
        NavHost(Navigations.current, Destinations.homescreen) {
            composable(Destinations.homescreen) { backStackEntry ->
                val viewModel = hiltNavGraphViewModel<WeatherViewModel>(backStackEntry)
                WeatherScreen(
                    viewModel = viewModel,
                    onLocationRequested = { onLocationRequested(viewModel) })
            }

            // other page
//            composable()
        }
    }


}