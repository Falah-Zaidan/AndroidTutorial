package com.example.second_course_starting_point.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SimpleList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(names) { name ->
            Text("Hi $name!")
        }
    }
}