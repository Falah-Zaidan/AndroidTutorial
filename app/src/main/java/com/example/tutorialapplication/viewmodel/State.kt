package com.example.tutorialapplication.viewmodel

import com.example.tutorialapplication.api.model.Character

data class State(
    var characters: List<Character> = listOf(),
)
