package com.pratamawijaya.podcastui.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsPadding
import com.pratamawijaya.podcastui.ui.theme.PodcastUITheme

@Composable
fun HomeScreen() {

    val scrollState = rememberLazyListState()

    Surface {
        LazyColumn(state = scrollState) {
            item {
                LargeTitle()
            }

            // todo: content error, success, loading

            item {
                Box(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(bottom = 32.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    PodcastUITheme {
        HomeScreen()
    }
}