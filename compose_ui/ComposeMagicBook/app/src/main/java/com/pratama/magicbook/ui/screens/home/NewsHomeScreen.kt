package com.pratama.magicbook.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratama.magicbook.ui.theme.ComposeMagicBookTheme
import com.pratama.magicbook.ui.theme.robotoFamily
import com.pratama.magicbook.utils.LogCompositions
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun NewsHomeScreen(modifier: Modifier = Modifier) {
    val sdf = SimpleDateFormat("EEE, d MMM yy - HH:mm:ss z")
    val currentDateAndTime = sdf.format(Date())

    var currentDate by remember {
        mutableStateOf(currentDateAndTime)
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        HeaderHome(currentDate = currentDate)
        Spacer(modifier = Modifier.height(16.dp))
        HeaderCarousel()
        Spacer(modifier = Modifier.height(16.dp))
        ListNewsItem()
        Spacer(modifier = Modifier.height(8.dp))
        ListNewsItem()
    }
}

@Composable
fun ListNewsItem(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .height(80.dp)
                .width(100.dp)
                .clip(shape = RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        ) {

        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "14 May 2023")
            Text(
                text = "Easy-to-Win Trade War Costs Taxpayers Money",
                fontFamily = robotoFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 20.sp
            )
        }

    }
}

@Composable
fun HeaderCarousel(modifier: Modifier = Modifier) {
    LogCompositions(tag = "home carousel", msg = "recompose home carousel")
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .clip(shape = RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .padding(all = 8.dp)
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Ini buat carousel")
        }
        Text(
            text = "24 May 2023",
            fontFamily = robotoFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 12.sp
        )
        Text(
            text = "Alex Jones Should Be Cross-Examined",
            fontFamily = robotoFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.W700
        )
        Text(
            text = "by New York Times",
            fontFamily = robotoFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.W400
        )
    }
}

@Composable
fun HeaderHome(modifier: Modifier = Modifier, currentDate: String) {

    Row(modifier = modifier.fillMaxWidth()) {
        Column {
            Text(
                text = "Newspaper",
                fontFamily = robotoFamily,
                fontSize = 36.sp,
                fontWeight = FontWeight.W700
            )
            Text(
                text = currentDate,
                fontFamily = robotoFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsHomeScreenPreview() {
    ComposeMagicBookTheme {
        NewsHomeScreen()
    }
}