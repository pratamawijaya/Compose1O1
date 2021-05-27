package com.pratamawijaya.weather.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pratamawijaya.weather.presentation.R

val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular),
    Font(R.font.nunito_sans_light, weight = FontWeight.Light),
    Font(R.font.nunito_sans_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_sans_semibold, weight = FontWeight.SemiBold)
)


// Set of Material typography styles to start with
val Typography = Typography(

    h1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),

    h2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    h5 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),

    subtitle1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),

    body1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),

    body2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),

    button = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp
    ),

    caption = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
)

val TypographyDark = Typography(

    h1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = Color.White
    ),

    h2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.White
    ),

    h5 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        color = Color.White
    ),

    subtitle1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.White
    ),

    body1 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = Color.White
    ),

    body2 = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color.White
    ),

    button = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        color = Color.White
    ),

    caption = TextStyle(
        fontFamily = NunitoSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        color = Color.White
    )
)