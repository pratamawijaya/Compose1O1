package com.pratamawijaya.layouting.ui.components

import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pratamawijaya.layouting.ui.theme.LayoutingTheme

@Composable
fun DemoButton() {
    Button(onClick = { }) {
        "Hello"
    }
}

@Preview("Demo Button")
@Composable
fun DefaultButtonPreview() {
    LayoutingTheme {
        DemoButton()
    }
}
