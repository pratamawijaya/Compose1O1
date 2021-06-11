package com.pratamawijaya.weather.data.repository

import android.util.Log
import com.pratamawijaya.weather.data.base.networkBoundResult
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl : WeatherRepository {
    override fun getWeatherByCity(cityName: String): Flow<Result<String>> {
        return networkBoundResult(
            query = {
                flow { "data from query" }
            },
            fetch = {
                "data from fetch"
            },
            saveFetchResult = {
                Log.d("tag", "buat simpan data $it")
            },
            onFetchFailed = {
                Log.e("tag", "kena throw ${it.localizedMessage}")
            },
            shouldFetch = {
                it.isEmpty()
            }

        )
    }
}