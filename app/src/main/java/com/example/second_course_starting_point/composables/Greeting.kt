package com.example.second_course_starting_point.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

// sizing using TextStyle
// Font sizing, use sp values to adapt to user preferences for text size
@Composable
fun Greeting(name: String = "", modifier: Modifier = Modifier) {
    Text(
        style = TextStyle(
            fontSize = 24.sp
        ),
        // String template
        text = "Hi $name!",
        modifier = modifier
    )
}