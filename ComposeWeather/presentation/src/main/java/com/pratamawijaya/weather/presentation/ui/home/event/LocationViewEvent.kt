package com.pratamawijaya.weather.presentation.ui.home.event

sealed class LocationViewEvent {
    data class SetLocation(val city: String) : LocationViewEvent()
    data class SearchCity(val query: String) : LocationViewEvent()
    object LocationError : LocationViewEvent()
}