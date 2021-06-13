package com.pratamawijaya.weather.domain.fakes

import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.model.Weather
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeWeatherRepository : WeatherRepository {
    override fun getWeatherByCity(cityName: String): Flow<Result<Weather>> {
        return flow {
            emit(Result.Success(generateWeather()))
        }
    }


}

fun generateWeather(): Weather {
    return Weather(temp = "12", maxTemp = "100", minTemp = "1")
}