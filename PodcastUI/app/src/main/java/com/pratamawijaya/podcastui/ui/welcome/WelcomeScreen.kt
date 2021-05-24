package com.pratamawijaya.podcastui.ui.welcome

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.navigate
import androidx.navigation.compose.popUpTo
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

}

@Preview(name = "Welcome")
@Composable
fun WelcomeScreenPreview() {
    ProviewCont
}