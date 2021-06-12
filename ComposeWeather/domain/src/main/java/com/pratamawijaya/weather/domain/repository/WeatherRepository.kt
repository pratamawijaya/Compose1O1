package com.pratamawijaya.weather.domain.repository

import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCity(cityName: String): Flow<Result<Weather>>
}