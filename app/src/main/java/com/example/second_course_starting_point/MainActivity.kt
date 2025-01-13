package com.example.second_course_starting_point

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.second_course_starting_point.composables.ImageExample
import com.example.second_course_starting_point.screens.MainScreen
import com.example.second_course_starting_point.screens.ProfileScreen
import com.example.second_course_starting_point.ui.theme.SecondcoursestartingpointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SecondcoursestartingpointTheme {
                // this is our screen controller, it knows about all the screens in our NavHost
                val navController = rememberNavController()

                // The NavHost holds all of our Composable screens
                NavHost(
                    navController = navController,
                    startDestination = "MainScreen",
                    builder = {
                        // This is our MainScreen, we need to pass it the navController to navigate to ProfileScreen
                        composable("MainScreen") {
                            MainScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        // This is our ProfileScreen
                        composable("ProfileScreen") {
                            ProfileScreen(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(top = 10.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}

// sizing using TextStyle
// Font sizing, use sp values to adapt to user preferences for text size
@Composable
fun Greeting(name: String = "", modifier: Modifier = Modifier) {
    Text(
        style = TextStyle(
            fontSize = 24.sp
        ),
        // String template
        text = "Hi $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecondcoursestartingpointTheme {
//        MainScreen(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
//        )
//        ImageExample()
        ProfileScreen(modifier = Modifier.padding(top = 10.dp))
    }
}