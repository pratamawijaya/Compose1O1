package com.pratamawijaya.domain.repository

import com.pratamawijaya.domain.model.Forecast
import com.pratamawijaya.domain.model.Weather

interface WeatherRepository {
    suspend fun getForecast(city: String): Forecast
    suspend fun getCurrentWeather(city: String): Weather
}