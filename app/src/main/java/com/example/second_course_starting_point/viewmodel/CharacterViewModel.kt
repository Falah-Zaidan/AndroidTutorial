package com.example.second_course_starting_point.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.second_course_starting_point.api.ApiService
import com.example.second_course_starting_point.api.RetrofitClient
import kotlinx.coroutines.launch

class CharacterViewModel(val retrofitClient: ApiService) : ViewModel() {

    // Our HTTP client that we need to make the network request

    // init block will 'getCharacters() with the class is first created'
    init {
        getCharacters()
    }

    fun getCharacters() {
        viewModelScope.launch {
            val characters = retrofitClient.getCharactersFromAPI()

            // forEach is a collection function that allows us to iterate through a List
            characters.forEach { character ->
                Log.d("Character", character.name)
            }
        }
    }

}

// Animal class - function to breathe

// Cat extends Animal - function to breathe will be available by default