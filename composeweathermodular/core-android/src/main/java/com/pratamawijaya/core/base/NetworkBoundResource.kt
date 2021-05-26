package com.pratamawijaya.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: suspend () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { Unit },
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {

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
                Result.Error(
                    throwable
                )
            }
        }
    } else {
        query().map { Result.Success(it) }
    }

    emitAll(flow)
}