package com.pratamawijaya.weather.presentation.ui.home.state

import com.pratamawijaya.weather.domain.model.Weather

data class WeatherState(
    val city: String = "",
    val weather: Weather = Weather(),
    val viewStatus: ViewStatus = ViewStatus.Idle
)

enum class ViewStatus {
    Idle,
    Loading,
    Running,
    HandlingError
}
