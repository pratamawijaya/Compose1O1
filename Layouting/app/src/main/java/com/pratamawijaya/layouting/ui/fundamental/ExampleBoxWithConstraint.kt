package com.pratamawijaya.layouting.ui.fundamental

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.layouting.ui.theme.LayoutingTheme

@Composable
fun ExampleBoxWithConstraint() {
    BoxWithConstraints {
        val rectangleHeight = 100.dp
        if (maxHeight < rectangleHeight * 2) {
            Box(
                Modifier
                    .size(50.dp, rectangleHeight)
                    .background(Color.Blue)
            )
        } else {
            Column {
                Box(
                    Modifier
                        .size(50.dp, rectangleHeight)
                        .background(Color.Blue)
                )
                Box(
                    Modifier
                        .size(50.dp, rectangleHeight)
                        .background(Color.Gray)
                )
            }
        }
    }

}

@Preview
@Composable
fun PreviewBoxWithConstraint() {
    LayoutingTheme {
        Scaffold() {
            ExampleBoxWithConstraint()
        }
    }
}