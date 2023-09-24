package com.example.tutorialapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tutorialapplication.viewmodel.ExampleViewModel
import com.example.tutorialapplication.viewmodel.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController, state: MutableState<State>) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "List Screen", fontSize = 30.sp) })
        },
        bottomBar = {},
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                LazyColumn {
                    items(state.value.characters) { item ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.CenterStart
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.navigate("DetailScreen/${item.id}")
                                    }
                            ) {
                                Text(
                                    text = item.name.toString(),
                                    style = TextStyle(
                                        fontSize = 24.sp
                                    ),
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}