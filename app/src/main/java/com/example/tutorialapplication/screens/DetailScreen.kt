package com.example.tutorialapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Detail Screen") })
        },
        bottomBar = {},
        content = { innerPadding ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Text("DetailScreen")
                LikeButton()
            }
        }
    )
}

@Composable
fun LikeButton() {

    var likeTrigger by remember { mutableStateOf(false) }

    if (likeTrigger) {
        Button(
            onClick = {
                likeTrigger = !likeTrigger
            },
            modifier = Modifier
        ) {
            Text("Button liked")
        }
    } else {
        Button(
            onClick = {
                likeTrigger = !likeTrigger
            },
            modifier = Modifier
        ) {
            Text("Button unliked")
        }
    }
}

@Preview
@Composable
fun PreviewDetailScreen() {

    val navController = rememberNavController()

    DetailScreen(navController = navController)
}