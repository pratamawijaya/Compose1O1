package com.pratamawijaya.weather.presentation.ui.home.event

import com.pratamawijaya.weather.presentation.ui.home.state.ViewStatus

sealed class ForecastViewEvent {
    data class GetForecast(val city: String) : ForecastViewEvent()
    data class SetViewStatus(val viewStatus: ViewStatus) : ForecastViewEvent()
}