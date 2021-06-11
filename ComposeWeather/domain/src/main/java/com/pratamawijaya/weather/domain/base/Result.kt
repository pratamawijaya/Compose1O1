package com.pratamawijaya.weather.domain.base

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()

    fun isLoading() = this is Loading
    fun isSuccessFull() = this is Success
}