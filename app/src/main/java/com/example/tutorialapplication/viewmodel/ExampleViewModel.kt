package com.example.tutorialapplication.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialapplication.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class ExampleViewModel : ViewModel() {

    val state : MutableState<State> = mutableStateOf(State())

    private val retrofitClient = RetrofitClient.createHttpClient()

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch{
            val characterList = retrofitClient.getCharacters()
            state.value = state.value.copy(
                characters = characterList
            )
        }
    }

}
