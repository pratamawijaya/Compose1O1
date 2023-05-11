package com.pratama.magicbook.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
fun OnboardingScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(
                text = "Welcome\n" +
                        "to MagicBook",
                fontFamily = robotoFamily,
                fontSize = 36.sp,
                fontWeight = FontWeight.W700,
                lineHeight = 40.sp,
                letterSpacing = (-0.2).sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Biggest collection of 300+ layouts \n" +
                        "for iOS prototyping.",
                fontFamily = robotoFamily,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                lineHeight = 22.sp,
                letterSpacing = (-0.4).sp
            )
            Spacer(modifier = Modifier.height(72.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    value = "Email", onValueChange = {})
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(shape = RoundedCornerShape(6.dp))
                    .background(Color.LightGray),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    value = "Password", onValueChange = {})
            }
            Spacer(modifier = Modifier.height(16.dp))

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
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Login",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = robotoFamily
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clip(shape = RoundedCornerShape(6.dp))
                .background(Color(0xFFCDCDCD)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Sign Up",
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = robotoFamily,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL)
@Composable
fun OnboardingScreenPreview() {
    ComposeMagicBookTheme {
        OnboardingScreen()
    }
}