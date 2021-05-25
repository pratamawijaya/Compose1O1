package com.pratamawijaya.domain.usecase

import com.pratamawijaya.domain.base.FlowUseCase
import com.pratamawijaya.domain.base.Result
import com.pratamawijaya.domain.di.IoDispatcher
import com.pratamawijaya.domain.model.CurrentWeather
import com.pratamawijaya.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetCurrentWeather constructor(
    private val repo: WeatherRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher
) : FlowUseCase<String, CurrentWeather>(dispatcher) {

    override fun execute(params: String): Flow<Result<CurrentWeather>> {
        return flow {
            emit(Result.Loading)

            emit(Result.Success(repo.getCurrentWeather(params)))
        }
    }

}