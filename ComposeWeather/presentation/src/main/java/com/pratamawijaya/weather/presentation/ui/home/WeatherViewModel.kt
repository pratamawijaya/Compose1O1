package com.pratamawijaya.weather.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.pratamawijaya.weather.domain.model.Weather
import com.pratamawijaya.weather.domain.usecase.GetWeather
import com.pratamawijaya.weather.presentation.ui.event.ForecastViewEvent
import com.pratamawijaya.weather.presentation.ui.home.state.ViewStatus
import com.pratamawijaya.weather.presentation.ui.home.state.WeatherState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeather: GetWeather) : ViewModel() {


    // state with stateFlow
    private val _weatherState = MutableStateFlow(WeatherState())
    val weatherState: StateFlow<WeatherState> = _weatherState

    fun onForecastEvent(event: ForecastViewEvent) = viewModelScope.launch {
        when (event) {
            is ForecastViewEvent.GetForecast -> {
                // call usecase
                getWeather(GetWeather.Param(event.city)).collectLatest { result ->
                    if (result.isSuccessFull()) {
                        _weatherState.emit(
                            weatherState.value.copy(
                                weather = Weather(), // fixme : pass data from usecase
                                viewStatus = ViewStatus.Running
                            )
                        )
                    }
                }
                getWeather.execute(GetWeather.Param("Jakarta")).collectLatest { result ->
                    d { "result viewmodel $result" }
                }
            }
        }
    }
}