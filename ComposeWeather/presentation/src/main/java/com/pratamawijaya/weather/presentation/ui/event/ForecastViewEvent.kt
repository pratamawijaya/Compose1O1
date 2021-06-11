package com.pratamawijaya.weather.presentation.ui.event

sealed class ForecastViewEvent {
    data class GetForecast(val city: String) : ForecastViewEvent()
}