package com.pratamawijaya.recreatepokedex

import android.view.MenuItem
import androidx.compose.runtime.Composable
import com.github.zsoltk.compose.router.Router

interface Root {
    sealed class Routing {
        object Home : Routing()
        object Pokedex : Routing()
    }

    companion object {
        @Composable
        fun Content(defaultRouting: Routing = Routing.Home) {
            Router(defaultRouting = defaultRouting) { backStack ->
                val onMenuItemSelected: (MenuItem) -> Unit = {
                    when (it) {
                    }
                }

                when (val routing = backStack.last()) {
//                    is Routing.Home ->Home
                }

            }
        }
    }
}