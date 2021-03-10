package com.pratamawijaya.recreatepokedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratamawijaya.recreatepokedex.ui.theme.RecreatepokedexTheme

@Composable
fun MainAppBar() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "What Pokémon\nare you looking for?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 32.dp)
        )
    }
}

@Preview
@Composable
fun PreviewMainAppBar() {
    RecreatepokedexTheme {
        Scaffold() {
            Surface() {
                MainAppBar()
            }
        }
    }
}