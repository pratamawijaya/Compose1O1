package com.pratamawijaya.weather.domain.usecase

import com.pratamawijaya.weather.domain.base.FlowUseCase
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.di.IoDispatcher
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeather @Inject constructor(
    private val repo: WeatherRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<GetWeather.Param, String>(dispatcher) {

    data class Param(
        val cityName: String
    )

    override fun execute(parameters: Param): Flow<Result<String>> {
        return repo.getWeatherByCity(parameters.cityName)
    }
}