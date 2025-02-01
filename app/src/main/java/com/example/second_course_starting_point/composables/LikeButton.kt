package com.example.second_course_starting_point.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.second_course_starting_point.R


// Marking with @Compose and using MutableState for reactive behaviour
// Any time there is a change to the MutableState, the Composable is re-composed/logic executed again
@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
) {
    var likeButtonState by remember { mutableStateOf(false) }

    if (likeButtonState) {
        Image(
            painter = painterResource(R.drawable.like_button_filled),
            contentDescription = "filled like button",
            modifier = Modifier.clickable {
                likeButtonState = !likeButtonState
            }
        )
    } else {
        Image(
            painter = painterResource(R.drawable.like_button_outlined),
            contentDescription = "outlined like button",
            modifier = Modifier.clickable {
                likeButtonState = !likeButtonState
            }
        )
    }
}

@Preview
@Composable
fun PreviewLikeButton() {
    LikeButton()
}