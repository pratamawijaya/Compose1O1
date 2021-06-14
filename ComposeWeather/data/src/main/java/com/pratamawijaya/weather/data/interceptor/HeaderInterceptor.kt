package com.pratamawijaya.weather.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("appid", "f22c51c0eaabd817a79c5afc129202d8").build()
        return chain.proceed(request)
    }
}