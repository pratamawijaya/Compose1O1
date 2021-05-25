package com.pratamawijaya.domain.base

sealed class Result<out R> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val error: Throwable) : Result<Nothing>()
    object Loading : Result<Nothing>()
}