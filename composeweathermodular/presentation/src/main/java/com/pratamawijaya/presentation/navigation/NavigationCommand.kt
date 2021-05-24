package com.pratamawijaya.presentation.navigation

import androidx.navigation.compose.NamedNavArgument

interface NavigationCommand {
    val arguments: List<NamedNavArgument>
    val destination: String

    companion object {
        val Default = object : NavigationCommand {
            override val arguments = emptyList<NamedNavArgument>()
            override val destination: String = ""
        }
    }
}