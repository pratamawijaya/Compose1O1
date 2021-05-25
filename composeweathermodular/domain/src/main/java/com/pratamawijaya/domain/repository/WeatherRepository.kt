package com.pratamawijaya.domain.repository

import com.pratamawijaya.domain.model.CurrentWeather
import com.pratamawijaya.domain.model.Forecast

interface WeatherRepository {
    suspend fun getForecast(city: String): Forecast
    suspend fun getCurrentWeather(city: String): CurrentWeather
}