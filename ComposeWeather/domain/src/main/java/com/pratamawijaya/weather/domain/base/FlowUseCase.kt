package com.pratamawijaya.weather.domain.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

abstract class FlowUseCase<in Param, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    operator fun invoke(parameters: Param): Flow<Result<R>> {
        return execute(parameters)
            .catch { e ->
                emit(Result.Error(Exception(e)))
            }.flowOn(coroutineDispatcher)
    }

    abstract fun execute(parameters: Param): Flow<Result<R>>
}