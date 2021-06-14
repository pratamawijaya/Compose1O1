package com.pratamawijaya.weather.data.di

import com.pratamawijaya.weather.data.datasource.network.WeatherServices
import com.pratamawijaya.weather.data.interceptor.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideHeaderInterceptor(): HeaderInterceptor {
        return HeaderInterceptor()
    }

    @Provides
    fun provideOkHttp(headerInterceptor: HeaderInterceptor): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Provides
    fun provideWeatherServices(retrofit: Retrofit): WeatherServices {
        return retrofit.create(WeatherServices::class.java)
    }
}