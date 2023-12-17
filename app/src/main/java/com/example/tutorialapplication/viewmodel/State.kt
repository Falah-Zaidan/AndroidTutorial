package com.example.tutorialapplication.viewmodel

import com.example.tutorialapplication.api.model.Character
import com.example.tutorialapplication.api.model.Spell

data class State(
    var characters: List<Character> = listOf(),
    var filteredCharacters: List<Character> = listOf(),
    var likedCharacters: List<Character> = listOf(),
    val spells: List<Spell> = listOf(),


    var stringList: List<String> = listOf(),
    var isLoading: Boolean = false,
    var displayError: Boolean = false
)
