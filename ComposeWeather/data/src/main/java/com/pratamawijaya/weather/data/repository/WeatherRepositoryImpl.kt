package com.pratamawijaya.weather.data.repository

import android.util.Log
import com.pratamawijaya.weather.data.base.networkBoundResult
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.model.Weather
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeatherByCity(cityName: String): Flow<Result<Weather>> {
        return networkBoundResult(
            query = {
                flow { Weather() }
            },
            fetch = {
                Weather()
            },
            saveFetchResult = {
                Log.d("tag", "buat simpan data $it")
            },
            onFetchFailed = {
                Log.e("tag", "kena throw ${it.localizedMessage}")
            },
            shouldFetch = {
                it == null
            }

        )
    }
}