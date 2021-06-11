package com.pratamawijaya.weather.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.weather.presentation.R
import com.pratamawijaya.weather.presentation.ui.theme.WeatherModularTheme
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CurrentWeather() {
    val date = Calendar.getInstance().time
    val formmater = SimpleDateFormat("E, dd MMM yyyy", Locale.getDefault())
    val currentDate = formmater.format(date)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.cloudy_weather),
            contentDescription = null,
            modifier = Modifier
                .height(68.dp)
                .width(68.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Today", style = MaterialTheme.typography.h1)
            Text(text = currentDate, style = MaterialTheme.typography.subtitle1)
        }
    }

}

@Preview
@Composable
fun PreviewCurrentWeather() {
    WeatherModularTheme {
        CurrentWeather()
    }
}

@Preview(name = "Dark Theme")
@Composable
fun PreviewDarkCurrentWeather() {
    WeatherModularTheme(darkTheme = true) {
        CurrentWeather()
    }
}