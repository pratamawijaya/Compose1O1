package com.pratamawijaya.podcastui.ui.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.podcastui.ui.common.PreviewContent
import com.pratamawijaya.podcastui.ui.navigation.Destination
import com.pratamawijaya.podcastui.ui.navigation.Navigator

@Composable
fun WelcomeScreen() {
    var visible by remember { mutableStateOf(false) }
    val navController = Navigator.current

    LaunchedEffect(true) {
        visible = true
    }

    WelcomeScreenContent(visible = visible) {
        navController.navigate(Destination.home) {
            popUpTo(Destination.welcome) { inclusive = true }
        }
    }
}

@Composable
fun WelcomeScreenContent(visible: Boolean, onGetStarted: () -> Unit) {
    Surface {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            AnimatedTile(visible = visible)

            AnimatedImage(visible = visible)

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedButton(visible = visible, onClick = onGetStarted)

        }
    }
}

@Preview(name = "Welcome")
@Composable
fun WelcomeScreenPreview() {
    PreviewContent {
        WelcomeScreenContent(visible = true) {}
    }
}

@Preview(name = "WelcomeDark")
@Composable
fun WelcomeScreenDarkPreview() {
    PreviewContent(darkTheme = true) {
        WelcomeScreenContent(visible = true) {}
    }
}