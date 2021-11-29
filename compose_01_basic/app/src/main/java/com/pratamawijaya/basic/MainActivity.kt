package com.pratamawijaya.basic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pratamawijaya.basic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(names: List<String> = listOf("World", "Compose")) {
    Column(modifier = Modifier.padding(4.dp)) {
        for (name in names) {
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expanded = remember {
        mutableStateOf(false)
    }

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(24.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(onClick = {
                expanded.value = !expanded.value
            }) {
                Text(text = if(expanded.value) "Show Less" else "Show More")
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        MyApp()
    }
}