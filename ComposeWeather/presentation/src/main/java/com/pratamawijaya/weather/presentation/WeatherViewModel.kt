package com.pratamawijaya.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pratamawijaya.weather.presentation.ui.event.ForecastViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

//@HiltViewModel
class WeatherViewModel : ViewModel() {

    fun onForecastEvent(event: ForecastViewEvent) = viewModelScope.launch {
        when (event) {
            is ForecastViewEvent.GetForecast -> {
                // call usecase
            }
        }
    }
}