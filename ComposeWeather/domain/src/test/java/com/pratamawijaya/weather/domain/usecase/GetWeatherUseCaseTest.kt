package com.pratamawijaya.weather.domain.usecase

import app.cash.turbine.test
import com.pratamawijaya.weather.domain.base.Result
import com.pratamawijaya.weather.domain.fakes.FakeWeatherRepository
import com.pratamawijaya.weather.domain.fakes.generateWeather
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
class GetWeatherUseCaseTest {

    private val coroutineDispatcher = TestCoroutineDispatcher()
    private val coroutineScope = TestCoroutineScope(coroutineDispatcher)

    private val repo = FakeWeatherRepository()
    private lateinit var useCase: GetWeatherUseCase

    @Before
    fun setUp() {
        useCase = GetWeatherUseCase(repo, coroutineDispatcher)
    }

    @Test
    fun `fetch weather should return Success`() = coroutineScope.runBlockingTest {
        //given
        val param = GetWeatherUseCase.Param("Jakarta")

        //when
        val result = useCase.execute(param)

        //then
        result.test {
            assertEquals(Result.Success(generateWeather()), expectItem())
            expectComplete()
        }
    }
}