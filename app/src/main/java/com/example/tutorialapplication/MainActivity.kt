package com.example.tutorialapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.example.tutorialapplication.api.HPNetworkClient
import com.example.tutorialapplication.screens.CharacterDetailScreen
import com.example.tutorialapplication.screens.FavouriteScreen
import com.example.tutorialapplication.screens.CharacterListScreen
import com.example.tutorialapplication.screens.SpellScreen
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme
import com.example.tutorialapplication.viewmodel.HPViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialApplicationTheme {
                val navController = rememberNavController()

                val viewModel = HPViewModel(HPNetworkClient.createHttpClient())

                NavHost(
                    navController = navController,
                    startDestination = "ListScreen", //this is the screen we start on
                    builder = {
                        composable(route = "ListScreen") {
                            CharacterListScreen(
                                navController = navController,
                                state = viewModel.state.collectAsState().value,
                                filterCharacters = { viewModel.filterCharacters(name = it) },
                                resetCharacters = { viewModel.resetCharacters() }
                            ) //we pass in the navController so it can be used in the Screen
                        }

                        composable(route = "SpellScreen") {
                            SpellScreen(
                                navController = navController,
                                state = viewModel.state.collectAsState().value
                            )
                        }

                        composable(route = "FavouriteScreen") {
                            FavouriteScreen(
                                navController = navController,
                                state = viewModel.state.collectAsState().value
                            )
                        }

                        composable(route = "DetailScreen/{character_id}",
                            arguments = listOf(
                                navArgument("character_id") {
                                    type = NavType.StringType
                                }
                            )) { backStackEntry ->

                            //Get the characterID that is passed in with navigation
                            val characterId =
                                backStackEntry.arguments?.getString("character_id") ?: ""

                            CharacterDetailScreen(
                                state = viewModel.state.collectAsState().value,
                                characterId = characterId,
                                likeCharacter = { viewModel.likeCharacter(characterId) })
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun TestText(name: String) {

    //Basic Text
    Text("Basic text")

    //Text with Padding (and using the name parameter)
    Text(
        modifier = Modifier.padding(10.dp),
        text = "My name is $name"
    )

    //Text stacked in a Column
    Column {
        Text(text = "Hello world")
        Text(text = "Text that is underneath Hello World")
    }

    //Text in a Row
    Row {
        Text("First item, ")
        Text("Second item")
    }
}

@Composable
fun ListExample() {

    val listOfNames = listOf("Najey", "Falah", "Luke", "Carlo", "Toufik")

    LazyColumn {
        items(listOfNames) { item ->
            Text(item)
        }
    }

}

@Composable
fun TestButton() {
    Button(
        onClick = {
            Log.d("MainActivityLog", "Button was clicked")
        },
        modifier = Modifier
    ) {
        Text("Test button")
    }
}

@Composable
fun ImageExample() {

    //PNG dragged into project (in res/drawable folder)
    Image(
        painterResource(id = R.drawable.tree),
        contentDescription = "Tree image"
    )

    //Vector asset created using the Clip art library (right click drawable folder -> New -> Vector Asset)
    Image(
        painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Android symbol"
    )

    //Image from a URL using the Coil library for Android
    val image =
        rememberImagePainter(data = "https://media.macphun.com/img/uploads/macphun/blog/2063/_1.jpeg?q=75&w=1710&h=906&resize=cover")

    Image(
        painter = image,
        contentDescription = "a Landscape",
        modifier = Modifier
            .size(100.dp)
            .padding(16.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center
    )
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    TutorialApplicationTheme {
        TestText("Falah")
    }
}