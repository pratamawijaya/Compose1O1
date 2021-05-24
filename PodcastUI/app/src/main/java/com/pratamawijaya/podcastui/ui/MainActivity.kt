package com.pratamawijaya.podcastui.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import com.pratamawijaya.podcastui.R
import com.pratamawijaya.podcastui.ui.home.HomeScreen
import com.pratamawijaya.podcastui.ui.navigation.Destination
import com.pratamawijaya.podcastui.ui.navigation.Navigator
import com.pratamawijaya.podcastui.ui.navigation.ProvideNavHostController
import com.pratamawijaya.podcastui.ui.theme.PodcastUITheme
import com.pratamawijaya.podcastui.ui.welcome.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.Theme_PodcastUI)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        val startDestination = Destination.welcome

        setContent {
            PodcastUiApp(
                backDispatcher = onBackPressedDispatcher,
                startDestination = startDestination
            )
        }
    }
}

@Composable
fun PodcastUiApp(
    startDestination: String = Destination.welcome,
    backDispatcher: OnBackPressedDispatcher
) {
    PodcastUITheme {
        ProvideNavHostController {
            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(Navigator.current, startDestination) {
                    composable(Destination.welcome) {
                        WelcomeScreen()
                    }

                    composable(Destination.home) {
                        HomeScreen()
                    }

                    composable(
                        Destination.podcast,
                        deepLinks = listOf(navDeepLink {
                            uriPattern = "https://anu.com/e/{id}"
                        })
                    ) { backStackEntry ->
                        // todo
                    }

                }
            }
        }
    }
}
