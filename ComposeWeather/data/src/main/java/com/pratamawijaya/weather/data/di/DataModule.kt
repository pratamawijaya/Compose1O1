package com.pratamawijaya.weather.data.di

import com.pratamawijaya.weather.data.repository.WeatherRepositoryImpl
import com.pratamawijaya.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideWeatherRepository(): WeatherRepository = WeatherRepositoryImpl()
}