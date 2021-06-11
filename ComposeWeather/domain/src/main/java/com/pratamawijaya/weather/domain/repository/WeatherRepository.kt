package com.pratamawijaya.weather.domain.repository

import com.pratamawijaya.weather.domain.base.Result
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherByCity(cityName: String): Flow<Result<String>>
}