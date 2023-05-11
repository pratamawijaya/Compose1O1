package com.pratama.magicbook.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.pratama.magicbook.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val robotoFont = GoogleFont("Roboto")
val robotoFamily = FontFamily(Font(googleFont = robotoFont, fontProvider = provider))

// Set of Material typography styles to start with
val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = robotoFamily,
//        fontWeight = FontWeight.Bold,
//        fontSize = 36.sp,
//        lineHeight = 40.sp,
//        letterSpacing = (-0.2).sp
//    ),
//    labelMedium = TextStyle(
//        fontFamily = robotoFamily,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 22.sp,
//        letterSpacing = (-0.4).sp
//    )
)