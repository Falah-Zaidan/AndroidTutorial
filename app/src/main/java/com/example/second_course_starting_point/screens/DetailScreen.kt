package com.example.second_course_starting_point.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.second_course_starting_point.api.CharacterModel
import com.example.second_course_starting_point.api.DataState
import com.example.second_course_starting_point.composables.ImageExample

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewData: DataState<CharacterModel>
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (viewData) {
            is DataState.Success -> {
                Text("This is the DetailScreen CharacterModel: ${viewData.data.name}")
            }

            is DataState.Loading -> {
                CircularProgressIndicator()
            }

            is DataState.Error -> {
                Text("Error")
            }

            is DataState.UnInitialised -> {
                // Nothing to display
            }
        }


        // profile picture
//        ImageExample()
//        Text("$viewModel.")
    }
}