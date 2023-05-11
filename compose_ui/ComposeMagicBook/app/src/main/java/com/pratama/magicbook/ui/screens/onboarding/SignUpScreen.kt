package com.pratama.magicbook.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratama.magicbook.ui.theme.ComposeMagicBookTheme
import com.pratama.magicbook.ui.theme.robotoFamily

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "Scheme\n" +
                        "iOS Wireframe\n" +
                        "Layouts",
                fontFamily = robotoFamily,
                fontSize = 36.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 40.sp,
                letterSpacing = (-0.2).sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Biggest collection of 300+ layouts \n" +
                        "for iOS prototyping.",
                fontFamily = robotoFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 22.sp,
                letterSpacing = (-0.4).sp
            )
        }
        Text(
            text = "Use Facebook to find your friends",
            color = Color(0xFF969FA2),
            fontSize = 14.sp,
            fontFamily = robotoFamily
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .background(
                    Color(
                        0xFF59B58D
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Login with Facebook",
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = robotoFamily
            )
        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun SignUpScreenPreview() {
    ComposeMagicBookTheme {
        SignUpScreen()
    }
}