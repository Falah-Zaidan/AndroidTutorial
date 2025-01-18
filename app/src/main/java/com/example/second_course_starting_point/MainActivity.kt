package com.example.second_course_starting_point

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.second_course_starting_point.screens.ListScreen
import com.example.second_course_starting_point.screens.DetailScreen
import com.example.second_course_starting_point.ui.theme.SecondcoursestartingpointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SecondcoursestartingpointTheme {
                // This is our screen controller, it knows about all the screens in our NavHost
                val navController = rememberNavController()

                // The NavHost holds all of our Composable screens
                NavHost(
                    navController = navController,
                    startDestination = "ListScreen",
                    builder = {
                        // This is our ListScreen, we need to pass it the navController to navigate to ProfileScreen
                        composable("ListScreen") {
                            ListScreen(
                                modifier = Modifier.fillMaxSize(),
                                navController = navController
                            )
                        }
                        // This is our DetailScreen
                        composable("DetailScreen") {
                            DetailScreen(
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

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    SecondcoursestartingpointTheme {
//        MainScreen(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
//        )
        DetailScreen(modifier = Modifier.padding(top = 10.dp))
    }
}