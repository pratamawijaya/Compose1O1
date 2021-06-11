package com.pratamawijaya.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.pratamawijaya.weather.domain.usecase.GetWeather
import com.pratamawijaya.weather.presentation.ui.event.ForecastViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeather: GetWeather) : ViewModel() {

    fun onForecastEvent(event: ForecastViewEvent) = viewModelScope.launch {
        when (event) {
            is ForecastViewEvent.GetForecast -> {
                // call usecase
                getWeather.execute(GetWeather.Param("Jakarta")).collectLatest { result ->
                    d { "result viewmodel $result" }
                }
            }
        }
    }
}