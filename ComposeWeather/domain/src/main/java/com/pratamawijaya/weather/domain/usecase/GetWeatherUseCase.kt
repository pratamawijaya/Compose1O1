package com.pratamawijaya.weather.domain.usecase

import com.pratamawijaya.weather.domain.base.FlowUseCase
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.di.IoDispatcher
import com.pratamawijaya.weather.domain.model.Weather
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repo: WeatherRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<GetWeatherUseCase.Param, Weather>(dispatcher) {

    data class Param(
        val cityName: String
    )

    override fun execute(parameters: Param): Flow<Result<Weather>> {
        return repo.getWeatherByCity(parameters.cityName)
    }
}