package com.example.second_course_starting_point.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.example.second_course_starting_point.api.CharacterModel
import com.example.second_course_starting_point.api.DataState
import com.example.second_course_starting_point.composables.LikeButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    viewData: DataState<CharacterModel>
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Character", fontSize = 30.sp) })
        },
        bottomBar = {},
        content = { innerPadding ->
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                when (viewData) {
                    is DataState.Success -> {
                        //Image from a URL using the Coil library for Android
                        val image = rememberAsyncImagePainter(model = viewData.data.image)
                        val character = viewData.data

                        Image(
                            painter = image,
                            contentDescription = "Character Image",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(400.dp)
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.Center
                        )

                        Box(modifier = Modifier.fillMaxWidth()) {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = character.name,
                                    style = TextStyle(
                                        fontSize = 32.sp
                                    )
                                )
                                Text(
                                    text = "Species: ${character.species}",
                                    style = TextStyle(
                                        fontSize = 24.sp
                                    )
                                )
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(end = 20.dp),
                                contentAlignment = Alignment.CenterEnd,
                            ) {
                                LikeButton()
                            }
                        }
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
            }
        }
    )
}