package com.pratamawijaya.podcastui.ui.common

import androidx.compose.runtime.Composable
import com.google.accompanist.insets.ProvideWindowInsets
import com.pratamawijaya.podcastui.ui.navigation.ProvideNavHostController
import com.pratamawijaya.podcastui.ui.theme.PodcastUITheme

@Composable
fun PreviewContent(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    PodcastUITheme(darkTheme = darkTheme) {
        ProvideWindowInsets {
            ProvideNavHostController {
                content()
            }
        }
    }

}