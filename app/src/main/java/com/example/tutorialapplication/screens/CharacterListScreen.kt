package com.example.tutorialapplication.screens

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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.tutorialapplication.R
import com.example.tutorialapplication.components.bottomnavigationbar.BottomNavigationBar
import com.example.tutorialapplication.components.SearchBarComponent
import com.example.tutorialapplication.viewmodel.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    navController: NavController,
    state: State,
    filterCharacters: (String) -> Unit,
    resetCharacters: () -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text(text = "Characters", fontSize = 30.sp) })
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator()
                } else if (state.displayError) {
                    Text("Error")
                } else {
                    SearchBarComponent(
                        filterCharacterFunc = filterCharacters,
                        resetCharactersFunc = resetCharacters
                    )
                    LazyColumn(Modifier.testTag("character_list")) {
                        items(state.filteredCharacters) { item ->
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
                                    val image =
                                        rememberImagePainter(data = item.image)

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
                                                    text = item.name.toString(),
                                                    style = TextStyle(
                                                        fontSize = 24.sp
                                                    )
                                                )
                                            }
                                            Box(
                                                modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                                                contentAlignment = Alignment.CenterEnd,
                                            ) {
                                                if (item.favourite) {
                                                    Image(
                                                        painterResource(id = R.drawable.baseline_favorite_24),
                                                        contentDescription = "heart filled"
                                                    )
                                                } else {
                                                    //display something else
                                                    Image(
                                                        painterResource(id = R.drawable.baseline_favorite_border_24),
                                                        contentDescription = "heart outlined"
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}