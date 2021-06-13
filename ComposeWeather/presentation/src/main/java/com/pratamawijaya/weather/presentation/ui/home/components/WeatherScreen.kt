package com.pratamawijaya.weather.presentation.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.weather.presentation.ui.home.WeatherViewModel
import com.pratamawijaya.weather.presentation.ui.home.components.CurrentWeather
import com.pratamawijaya.weather.presentation.ui.home.state.WeatherState
import com.pratamawijaya.weather.presentation.ui.theme.WeatherModularTheme

@Composable
fun WeatherScreen(viewModel: WeatherViewModel, onLocationRequested: () -> Unit) {

    val viewModelState by viewModel.weatherState.collectAsState(WeatherState())

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
                    .fillMaxWidth(),
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
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = Color.Magenta,
                    textColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.DarkGray
                ),
                singleLine = true
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
//        WeatherScreen()
    }
}

@Preview(name = "Dark Theme")
@Composable
fun PreviewDarkWeatherScreen() {
    WeatherModularTheme(darkTheme = true) {
//        WeatherScreen()
    }
}