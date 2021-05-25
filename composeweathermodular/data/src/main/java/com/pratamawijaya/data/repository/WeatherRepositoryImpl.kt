package com.pratamawijaya.data.repository

import com.pratamawijaya.domain.model.Forecast
import com.pratamawijaya.domain.model.Weather
import com.pratamawijaya.domain.repository.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override suspend fun getForecast(city: String): Forecast {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentWeather(city: String): Weather {
        TODO("Not yet implemented")
    }
}