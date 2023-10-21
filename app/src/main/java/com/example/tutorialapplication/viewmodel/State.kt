package com.example.tutorialapplication.viewmodel

import com.example.tutorialapplication.api.model.Character

data class State(
    var characters: List<Character> = listOf(),
    var filteredCharacters: List<Character> = listOf(),
    var stringList: List<String> = listOf(),
    var isLoading: Boolean = false,
    var displayError: Boolean = false
)
