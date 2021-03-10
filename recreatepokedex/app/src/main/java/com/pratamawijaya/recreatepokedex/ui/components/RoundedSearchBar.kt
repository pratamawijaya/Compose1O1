package com.pratamawijaya.recreatepokedex.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.recreatepokedex.ui.theme.RecreatepokedexTheme

@Composable
fun RoundedSearchBar() {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .height(48.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Search Pokemon, Move, Ability,etc",
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewRoundedSearchBar() {
    RecreatepokedexTheme {
        RoundedSearchBar()
    }
}