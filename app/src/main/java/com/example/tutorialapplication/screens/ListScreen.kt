package com.example.tutorialapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {

    //Using a Scaffold here - this is a template to structure a screen with a topBar, BottomBar and content

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("List Screen") })
        },
        bottomBar = {},
        content = { innerPadding ->
            val listOfNames = listOf("Falah", "Luke", "Carlo", "Cleo")

            Column(modifier = Modifier.padding(innerPadding)) {
                LazyColumn {
                    items(listOfNames) { item ->
                        Text(
                            text = item,
                            style = TextStyle(
                                fontSize = 30.sp
                            ),
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { //Setting each Text to be clickable
                                    //Using the passed in navController to navigate to the DetailScreen
                                    navController.navigate("DetailScreen")
                                })
                    }
                }
            }

        }
    )
}

@Preview
@Composable
fun PreviewListScreen() {
    val navController = rememberNavController()

    ListScreen(navController = navController)
}