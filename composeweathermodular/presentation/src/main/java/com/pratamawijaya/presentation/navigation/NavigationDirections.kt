package com.pratamawijaya.presentation.navigation

import androidx.navigation.compose.NamedNavArgument

object NavigationDirections {
    val Forecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination: String = "forecast"
    }
}