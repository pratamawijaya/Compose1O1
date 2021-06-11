package com.pratamawijaya.weather.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.ajalt.timberkt.d
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.usecase.GetWeather
import com.pratamawijaya.weather.presentation.ui.event.ForecastViewEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val getWeather: GetWeather) : ViewModel() {

    sealed class WeatherState {
        object InitState : WeatherState()
        object Loading : WeatherState()
        data class Error(val err: String) : WeatherState()
    }

    // state with stateFlow
    private val _weatherState = MutableStateFlow(WeatherState.InitState)
    val weatherState: StateFlow<WeatherState> = _weatherState

    fun onForecastEvent(event: ForecastViewEvent) = viewModelScope.launch {
        when (event) {
            is ForecastViewEvent.GetForecast -> {
                // call usecase
//                getWeather.execute(GetWeather.Param("")).collect {
//                    when (it) {
//                        Result.Loading -> {
//
//                        }
//
//                        Result.Error() -> {
//
//
//                        }
//                    }
//                }
                getWeather.execute(GetWeather.Param("Jakarta")).collectLatest { result ->
                    d { "result viewmodel $result" }
                }
            }
        }
    }
}