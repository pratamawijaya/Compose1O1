package com.pratamawijaya.podcastui.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pratamawijaya.podcastui.R

val NunitoSans = FontFamily(
    Font(R.font.nunito_sans_regular),
    Font(R.font.nunito_sans_light, weight = FontWeight.Light),
    Font(R.font.nunito_sans_bold, weight = FontWeight.Bold),
    Font(R.font.nunito_sans_semibold, weight = FontWeight.SemiBold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)