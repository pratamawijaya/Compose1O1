package com.pratamawijaya.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pratamawijaya.presentation.base.LocationActivity
import com.pratamawijaya.presentation.navigation.NavigationDirections
import com.pratamawijaya.presentation.navigation.NavigationManager
import com.pratamawijaya.presentation.theme.ComposeWeatherModularTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivity : LocationActivity() {

    private var forecastViewModel: ForecastViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeWeatherModularTheme {
                HelloWorld()
            }
        }
    }

    override fun onLocationSuccess(cityName: String) {
        TODO("Not yet implemented")
    }

    override fun onLocationFailure() {
        TODO("Not yet implemented")
    }

    override fun onLocationRequestCanceled() {
        TODO("Not yet implemented")
    }

}

@Composable
fun HelloWorld() {
    Surface {
        Column {
            Text(text = "Hello")
        }
    }
}

@Composable
fun App(onLocationRequested: (ForecastViewModel) -> Unit = {}) {

    val navController = rememberNavController()

    NavigationManager.command.collectAsState().value.also { command ->
        if (command.destination.isNotEmpty()) {
            navController.navigate(command.destination)
        }
    }

    NavHost(
        navController = navController,
        startDestination = NavigationDirections.Forecast.destination,
    ) {
        composable(NavigationDirections.Forecast.destination) { navBackStackEntry ->
            // todo
        }
    }
}