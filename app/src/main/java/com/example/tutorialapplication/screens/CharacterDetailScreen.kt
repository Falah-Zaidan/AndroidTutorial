package com.example.tutorialapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.tutorialapplication.R
import com.example.tutorialapplication.viewmodel.State

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(state: State, characterId: String, likeCharacter: () -> Unit) {

    val character = state.filteredCharacters.single { it.id == characterId }

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
                //Image from a URL using the Coil library for Android
                val image =
                    rememberImagePainter(data = character.image)

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

                Box(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = character.name.toString(),
                            style = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        Text(
                            text = "Ancestry: ${character.ancestry.toString()}",
                            style = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        Text(
                            text = "Species: ${character.species.toString()}",
                            style = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                        Text(
                            text = "Date of birth: ${character.dateOfBirth.toString()}",
                            style = TextStyle(
                                fontSize = 24.sp
                            )
                        )
                    }
                    Box(
                        modifier = Modifier.fillMaxWidth().padding(end = 20.dp),
                        contentAlignment = Alignment.CenterEnd,
                    ) {
                        if (character.favourite) {
                            Image(
                                painterResource(id = R.drawable.baseline_favorite_24),
                                contentDescription = "heart filled",
                                modifier = Modifier.clickable {
                                    likeCharacter.invoke()
                                }
                            )
                        } else {
                            //display something else
                            Image(
                                painterResource(id = R.drawable.baseline_favorite_border_24),
                                contentDescription = "heart outlined",
                                modifier = Modifier.clickable {
                                    likeCharacter.invoke()
                                }
                            )
                        }
                    }
                }
            }
        }
    )
}
