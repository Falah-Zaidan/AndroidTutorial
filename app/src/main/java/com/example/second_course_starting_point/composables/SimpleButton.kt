package com.example.second_course_starting_point.composables

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

// Set click behaviour and button background color
@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            println("Button was clicked")
        }, modifier = modifier,
        colors = ButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White,
            disabledContentColor = Color.Blue,
            disabledContainerColor = Color.Blue
        )
    ) {
        Text("Button")
    }
}