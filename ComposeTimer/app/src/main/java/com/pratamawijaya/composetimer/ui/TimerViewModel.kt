package com.pratamawijaya.composetimer.ui

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


data class CountDown(
    var hours: Int = 0,
    var minute: Int = 0,
    var second: Int = 0
) {
    fun toMillis(): Long {
        return this.hours * 3600000L + this.minute * 60000L + this.second * 1000
    }
}

fun MutableLiveData<CountDown>.update(
    hours: Int? = null,
    minutes: Int? = null,
    seconds: Int? = null,
    millis: Long? = null
) {
    var value = this.value?.copy() ?: CountDown()

    hours?.let { value.hours = it }
    minutes?.let { value.minute = it }
    seconds?.let { value.second = it }
    millis?.let { value = it.toCountDown() }

    this.value = value
}

fun MutableLiveData<CountDown>.reset() {
    this.value = CountDown()
}

fun Long.toCountDown(): CountDown {
    val hours = this / 3600000L
    val minutes = (this - hours * 3600000L) / 60000L
    val seconds = (this - minutes * 60000L - hours * 3600000L) / 1000L
    return CountDown(hours.toInt(), minutes.toInt(), seconds.toInt())
}

class TimerViewModel : ViewModel() {

    sealed class TimerState {
        object Finished : TimerState()
        object Running : TimerState()
        object Paused : TimerState()
    }

    private var _timerState = MutableLiveData<TimerState>()
    private lateinit var countDownTimer: CountDownTimer

    private var _countDown = MutableLiveData(CountDown())
    val countDown: LiveData<CountDown> = _countDown

    fun onStartClick() {
        if (_timerState.value == TimerState.Running) {
            pauseTimer()
        } else {
            startTimer()
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(_countDown.value?.toMillis() ?: 0L, 1_000) {
            override fun onTick(millisUntilFinished: Long) {
                _countDown.update(millis = millisUntilFinished)
            }

            override fun onFinish() {
                _timerState.value = TimerState.Finished
            }
        }.start()
        _timerState.value = TimerState.Running
    }

    private fun pauseTimer() {
        countDownTimer.cancel()
        _timerState.value = TimerState.Paused
    }

    fun stopTimer() {
        if (_timerState.value == TimerState.Running) {
            countDownTimer.cancel()
        }
        _countDown.reset()
        _timerState.value = TimerState.Finished
    }


}