package com.pratamawijaya.weather.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pratamawijaya.weather.presentation.ui.home.WeatherViewModel
import com.pratamawijaya.weather.presentation.ui.home.components.WeatherScreen

object MainDestinations {
    const val HOME_ROUTE = "home"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.HOME_ROUTE) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(MainDestinations.HOME_ROUTE) { navBackStackEntry ->
            val viewModel = hiltViewModel<WeatherViewModel>(navBackStackEntry)
            WeatherScreen(viewModel = viewModel, onLocationRequested = {})
        }
    }
}