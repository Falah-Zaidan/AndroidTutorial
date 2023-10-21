package com.example.tutorialapplication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent(filterCharacterFunc : (String) -> Unit, resetCharactersFunc : () -> Unit) {

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable {
        mutableStateOf(false)
    }

    SearchBar(
        modifier = Modifier.fillMaxWidth(),
        query = text,
        onQueryChange = {
            text = it
        },
        onSearch = { name ->
            active = false
            //do something with name
            filterCharacterFunc.invoke(name)
        },
        active = active,
        onActiveChange = {
             active = it
        },
        placeholder = {
            Text("Search by name")
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = "clear icon",
                modifier = Modifier.clickable {
                    resetCharactersFunc.invoke()
                }
            )
        }
    ) {}


}