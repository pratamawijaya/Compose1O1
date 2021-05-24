package com.pratamawijaya.podcastui.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import com.pratamawijaya.podcastui.R
import com.pratamawijaya.podcastui.ui.theme.PodcastUITheme

@Composable
fun LargeTitle() {
    Box(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 24.dp)
            .padding(bottom = 32.dp)
            .height(120.dp)
    ) {
        Text(
            stringResource(id = R.string.trending_now),
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun PreviewLargeTitle() {
    PodcastUITheme {
        LargeTitle()
    }
}