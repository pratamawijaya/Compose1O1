package com.pratamawijaya.weather.data.base

import com.pratamawijaya.weather.domain.base.Result
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResult(
    crossinline query: suspend () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { Unit },
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow<Result<ResultType>> {

    emit(Result.Loading)

    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Result.Loading)

        try {
            saveFetchResult(fetch())
            query().map { Result.Success(it) }
        } catch (throwable: Throwable) {
            onFetchFailed(throwable)
            query().map {
                Result.Error(throwable)
            }
        }
    } else {
        query().map { Result.Success(it) }
    }

    emitAll(flow)
}