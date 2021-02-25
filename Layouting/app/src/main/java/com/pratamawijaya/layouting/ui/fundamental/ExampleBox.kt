package com.pratamawijaya.layouting.ui.fundamental

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.layouting.ui.theme.LayoutingTheme

@Composable
fun BoxLayouting() {
    Box {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        )
        Box(
            Modifier.matchParentSize()
                .padding(top = 20.dp, bottom = 20.dp)
                .background(Color.Yellow)
        )
        Box(
            Modifier.matchParentSize()
                .padding(40.dp)
                .background(Color.Magenta)
        )
        Box(
            Modifier.align(Alignment.Center)
                .size(300.dp, 300.dp)
                .background(Color.Green)
        )
        Box(
            Modifier.align(Alignment.TopStart)
                .size(150.dp, 150.dp)
                .background(Color.Red)
        )
    }

}


@Preview
@Composable
fun PreviewBaxLayouting() {
    LayoutingTheme {
        BoxLayouting()
//        Scaffold {
//
//        }
    }
}