package com.pratamawijaya.weather.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.weather.presentation.ui.components.CurrentWeather
import com.pratamawijaya.weather.presentation.ui.theme.WeatherModularTheme

@Composable
fun WeatherScreen() {
    var city by remember { mutableStateOf("") }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = city,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(64.dp),
                placeholder = { Text(text = "Search City Weather") },
                onValueChange = {
                    city = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Green
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            CurrentWeather()

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "25.0",
                style = MaterialTheme.typography.h1,
                textAlign = TextAlign.Center
            )

        }
    }
}


@Preview
@Composable
fun PreviewWeatherScreen() {
    WeatherModularTheme {
        WeatherScreen()
    }
}