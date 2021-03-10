package com.pratamawijaya.recreatepokedex.ui.screens

import android.view.MenuItem
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

interface Home {

    companion object {

        @Composable
        fun Content(onMenuItemSelected: (MenuItem) -> Unit) {
            Column {
            }
        }
    }
}