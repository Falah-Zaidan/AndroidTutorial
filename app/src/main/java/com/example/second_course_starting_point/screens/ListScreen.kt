package com.example.second_course_starting_point.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import coil3.compose.rememberAsyncImagePainter
import com.example.second_course_starting_point.api.CharacterModel
import com.example.second_course_starting_point.api.DataState

// Each Composable should only have one root element
// Each Composable should also take a modifier, where the parent can set the size of the child
// Apply padding to adjust content sizing rather than specifying fixed dp values
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewData: DataState<List<CharacterModel>>,
) {
//    val character_id = "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Characters", fontSize = 30.sp) })
        },
        bottomBar = {
//            BottomNavigationBar(navController = navController)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (viewData) {
                    is DataState.Success -> {
                        LazyColumn {
                            items(viewData.data) { item ->
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
                                        val image = rememberAsyncImagePainter(model = item.image)

                                        Column(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {

                                            Box {
                                                Image(
                                                    painter = image,
                                                    contentDescription = "Character Image",
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(400.dp)
                                                        .padding(16.dp),
                                                    contentScale = ContentScale.Crop,
                                                    alignment = Alignment.Center
                                                )
                                            }

                                            Box(modifier = Modifier.fillMaxWidth()) {
                                                Box(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    contentAlignment = Alignment.Center
                                                ) {
                                                    Text(
                                                        text = item.name,
                                                        style = TextStyle(
                                                            fontSize = 24.sp
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    is DataState.Loading -> {
                        CircularProgressIndicator()
                    }
                    is DataState.Error -> {
                        Text("Error")
                    }
                    else -> {
                        // Do nothing
                    }
                }
            }
        }
    )
}