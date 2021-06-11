package com.pratamawijaya.weather.data.repository

import com.pratamawijaya.weather.domain.repository.WeatherRepository

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeatherByCity(cityName: String): String {
        return "Hello"
    }
}