package com.example.second_course_starting_point.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second_course_starting_point.api.CharacterModel
import com.example.second_course_starting_point.api.DataState
import com.example.second_course_starting_point.api.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {

    val state: MutableStateFlow<DataState<List<CharacterModel>>> =
        MutableStateFlow(DataState.UnInitialised)
    val characterState: MutableStateFlow<DataState<CharacterModel>> =
        MutableStateFlow(DataState.UnInitialised)

    // Our HTTP client that we need to make the network request
    val retrofitClient = RetrofitClient.createHttpClient()

    // init block will 'getCharacters() with the class is first created'
    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            state.value = DataState.Loading
            try {
                val characters = retrofitClient.getCharactersFromAPI()
                state.value = DataState.Success(characters)
            } catch (exception: Exception) {
                state.value =
                    DataState.Error(exception.localizedMessage ?: "Error fetching characters")
            }
            // forEach is a collection function that allows us to iterate through a List
//            characters.forEach { character ->
//                Log.d("Character", character.name)
//            }
        }
    }

    fun filterCharacters(characterId: String) {
        characterState.value = DataState.Loading

        val character = (state.value as? DataState.Success)?.data?.first {
            it.id == characterId
        }

        if (character != null) {
            characterState.value = DataState.Success(character)
        } else {
            characterState.value = DataState.Error("An error has occurred")
        }
    }
}

// Animal class - function to breathe

// Cat extends Animal - function to breathe will be available by default