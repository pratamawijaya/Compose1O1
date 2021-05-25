package com.pratamawijaya.domain.model

data class Forecast(
    val city: String,
    val dailyForecast: List<DailyForecast> = emptyList()
)

data class DailyForecast(
    val timestamp: String = "",
    val hourlyForecast: List<HourlyForecast> = emptyList(),
    val temperature: Int,
    val minTemperature: Int,
    val maxTemperature: Int,
    val weather: Weather = Weather.Sunny
)

data class HourlyForecast(
    val timestamp: String,
    val temperature: Int,
    val weather: Weather
)

enum class Weather {
    Sunny,
    Cloudy,
    Rainy,
    Thunderstorm,
    Windy
}