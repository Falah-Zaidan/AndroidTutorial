package com.example.tutorialapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tutorialapplication.bottomnavigationbar.BottomNavigationBar
import com.example.tutorialapplication.viewmodel.State

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SpellScreen(
    navController: NavController,
    state: State
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                androidx.compose.material3.Text(
                    text = "Spells",
                    fontSize = 30.sp
                )
            })
        },
        bottomBar = {
            BottomNavigationBar(navController)
        },
        //Scaffold padding requirement: https://stackoverflow.com/questions/66573601/bottom-nav-bar-overlaps-screen-content-in-jetpack-compose
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (state.isLoading) {
                    androidx.compose.material3.CircularProgressIndicator()
                } else if (state.displayError) {
                    androidx.compose.material3.Text("Error")
                } else {
                    if (state.isLoading) {
                        CircularProgressIndicator()
                    } else if (state.displayError) {
                        Text("Error")
                    } else {
                        LazyColumn {
                            items(state.spells) { spell ->
                                Column(modifier = Modifier.padding(10.dp)) {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = spell.name,
                                        fontSize = 24.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold,
                                        textAlign = TextAlign.Center
                                    )
                                    Spacer(modifier = Modifier.height(3.dp))
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = spell.description,
                                        fontSize = 18.sp,
                                        color = Color.Black,
                                        fontWeight = FontWeight.Medium,
                                        textAlign = TextAlign.Center
                                    )
                                    Divider(Modifier.padding(top = 5.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}