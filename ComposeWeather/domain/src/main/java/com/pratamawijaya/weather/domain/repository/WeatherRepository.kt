package com.pratamawijaya.weather.domain.repository

interface WeatherRepository {
    fun getWeatherByCity(cityName: String): String
}