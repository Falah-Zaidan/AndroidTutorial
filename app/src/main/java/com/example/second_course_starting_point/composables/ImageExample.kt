package com.example.second_course_starting_point.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import com.example.second_course_starting_point.R

@Composable
fun ImageExample() {

    // PNG into project
//    Image(
//        painterResource(R.drawable.dice),
//        "A simple image"
//    )

    // Vector asset into project
//    Image(
//        painterResource(R.drawable.image_vector),
//        "A simple image vector"
//    )

    // Using the coil library
    val image = rememberAsyncImagePainter("https://picsum.photos/200/300")

    // contentScale AND .clip() depend on each other,
    // compose will try to fit larger images if no content scale specified
    // Clipping this to 
    Image(
        painter = image,
        modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .clip(RoundedCornerShape(100))
            .clickable {
                // launch camera/access gallery
                Log.d("ImageExample", "Image clicked")
            },
        contentScale = ContentScale.Crop,
        contentDescription = "coil image"
    )
}