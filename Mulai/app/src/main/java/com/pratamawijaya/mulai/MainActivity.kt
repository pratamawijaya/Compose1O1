package com.pratamawijaya.mulai

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pratamawijaya.mulai.ui.components.Greeting
import com.pratamawijaya.mulai.ui.theme.MulaiTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyScreenContent() {
    Column {
        Greeting(name = "Android")
        Divider(color = Color.Black)
        Greeting(name = "There")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MulaiTheme() {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}


@Preview("App Preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}