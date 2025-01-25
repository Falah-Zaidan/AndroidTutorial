package com.example.second_course_starting_point.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.second_course_starting_point.composables.LikeButton

// Each Composable should only have one root element
// Each Composable should also take a modifier, where the parent can set the size of the child
// Apply padding to adjust content sizing rather than specifying fixed dp values
@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) { // taking in NavController
    // Stack contents one below/on top of each other

    val character_id = "5"
    Column(
        modifier = modifier
            .background(Color.White)
            .clickable {
                // Pass in the argument when the user clicks on the column,
                // it must be of the expected type
                navController.navigate("DetailScreen/$character_id")
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Greeting("Falah")
//        Greeting("Yuning")
//        Greeting("Kristina")
//        Greeting("Nnamdi")
//        val listOfNames = listOf("Falah", "Yuning", "Kristina", "Nnamdi")
//        SimpleList(listOfNames)
//        SimpleButton(
//            modifier = Modifier
//        )
        LikeButton()
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