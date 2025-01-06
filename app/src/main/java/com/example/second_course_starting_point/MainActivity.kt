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
import com.example.second_course_starting_point.ui.theme.SecondcoursestartingpointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SecondcoursestartingpointTheme {
                MainScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}


// Each Composable should only have one root element
// Each Composable should also take a modifier, where the parent can set the size of the child
// Apply padding to adjust content sizing rather than specifying fixed dp values
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Stack contents one below/on top of each other
    Column(
        modifier = modifier.background(Color.Yellow),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Greeting("Falah")
//        Greeting("Yuning")
//        Greeting("Kristina")
//        Greeting("Nnamdi")
        ListOfNames()
        SimpleButton(
            modifier = Modifier
        )
    }

    // Stack contents one after the other
//    Row(
//        modifier = modifer,
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {
//        Greeting("Falah")
//        Greeting("Yuning")
//        Greeting("Kristina")
//        Greeting("Nnamdi")
//    }

    // Stack contents over each other
    // Useful for things like badges
//    Box(
//        modifier = modifer,
//        contentAlignment = Alignment.Center
//    ) {
//        Greeting("Falah")
//        Greeting("Yuning")
//        Greeting("Kristina")
//        Greeting("Nnamdi")
//    }
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

@Composable
fun ListOfNames() {

    val listOfNames = listOf("Falah", "Yuning", "Kristina", "Nnamdi")

    LazyColumn {
        items(listOfNames) { name ->
            Text("Hi $name!")
        }
    }
}

// Set click behaviour and button background color
@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            println("Button was clicked")
        }, modifier = modifier,
        colors = ButtonColors(
            containerColor = Color.Red,
            contentColor = Color.White,
            disabledContentColor = Color.Blue,
            disabledContainerColor = Color.Blue
        )
    ) {
        Text("Name of Button")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecondcoursestartingpointTheme {
        MainScreen(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp, top = 15.dp, bottom = 15.dp)
        )
    }
}