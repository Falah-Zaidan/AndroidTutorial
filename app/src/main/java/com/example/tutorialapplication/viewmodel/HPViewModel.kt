package com.example.tutorialapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialapplication.api.HPService
import com.example.tutorialapplication.api.model.Character
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HPViewModel(
    private val hpService: HPService
) : ViewModel() {

    //MutableStateFlow instead of 'mutableStateOf{}' - https://stackoverflow.com/questions/68702217/mutablestate-in-view-model
    var _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> get() = _state

    init {
        getCharacters()
        getSpells()
    }

    fun getCharacters() {
        _state.value = state.value.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val characterList = hpService.getCharacters()
//                state.value.characters = characterList
                _state.value = state.value.copy(
                    characters = characterList,
                    filteredCharacters = characterList,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = state.value.copy(displayError = true, isLoading = false)

                if (e is HttpException) {
                    Log.e("HttpException", "${e.code()}: ${e.message}")
                }
            }
        }
    }

    fun getSpells() {
        _state.value = state.value.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val spellList = hpService.getSpells()
                _state.value = state.value.copy(
                    spells = spellList,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = state.value.copy(displayError = true, isLoading = false)

                if (e is HttpException) {
                    Log.e("HttpException", "${e.code()}: ${e.message}")
                }
            }
        }
    }

    fun likeCharacter(characterId: String) {
        val characters = state.value.characters

        val character = characters.single { it.id == characterId }

        //Create a new Character object with the favourite field set to true/false when the user triggers the method
        val newCharacter: Character = if (!character.favourite) {
            character.copy(favourite = true)
        } else {
            character.copy(favourite = false)
        }

        //create a new list and copy all elements from 'filteredCharacters' except the one the user has liked,
        //we copy the newCharacter object with 'favourite' set to true/false
        val newList = mutableListOf<Character>()

        for (character in characters) {
            if (character.id == characterId) {
                newList.add(newCharacter)
            } else {
                newList.add(character)
            }
        }

        _state.value = _state.value.copy(
            filteredCharacters = newList,
            characters = newList,
            likedCharacters = newList.filter { it.favourite }
        )
    }

    fun filterCharacters(name: String) {

        val characters = _state.value.characters
        val filteredCharacter = characters.filter { name.lowercase() == it.name?.lowercase() }

        _state.value = _state.value.copy(filteredCharacters = filteredCharacter)

    }

    fun resetCharacters() {
        val characters = state.value.characters
        _state.value = _state.value.copy(filteredCharacters = characters)
    }
}

