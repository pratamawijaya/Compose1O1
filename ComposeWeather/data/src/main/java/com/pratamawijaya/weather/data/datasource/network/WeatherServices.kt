package com.pratamawijaya.weather.data.datasource.network

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherServices {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(@Query("q") cityName: String)
}