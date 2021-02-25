package com.pratamawijaya.layouting.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.pratamawijaya.layouting.ui.theme.LayoutingTheme

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)


@Composable
fun BodyContent(modifier: Modifier = Modifier) {
//    StaggeredGrid(modifier = modifier) {
//        for (topic in topics) {
//            Chip(modifier = Modifier.padding(8.dp), text = topic)
//        }
//    }
}

@Composable
fun StaggeredGrid(modifier: Modifier, function: () -> Unit) {

}


@Preview
@Composable
fun StaggeredGridPreview() {
    LayoutingTheme() {

    }
}