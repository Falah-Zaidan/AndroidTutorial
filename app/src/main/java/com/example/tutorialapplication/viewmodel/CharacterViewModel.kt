package com.example.tutorialapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorialapplication.api.HPService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class CharacterViewModel(
    val retrofitClient: HPService
) : ViewModel() {

    //MutableStateFlow instead of 'mutableStateOf{}' - https://stackoverflow.com/questions/68702217/mutablestate-in-view-model
    var _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state: StateFlow<State> get() = _state

    init {
        getCharacters()
    }

    fun getCharacters() {
        _state.value = state.value.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val characterList = retrofitClient.getCharacters()
//                state.value.characters = characterList
                _state.value = state.value.copy(
                    characters = characterList,
                    filteredCharacters = characterList,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = state.value.copy(displayError = true, isLoading = false)

                if (e is HttpException) {
                    when (e.code()) {
                        400 -> { //Bad request
                            Log.e("HttpException", "${e.code()}: ${e.message}")
                            //Do something
                        }

                        401 -> { //Unauthorized Error
                            Log.e("HttpException", "${e.code()}: ${e.message}")
                            //Do something
                        }

                        403 -> { //Forbidden
                            Log.e("HttpException", "${e.code()}: ${e.message}")
                            //Do something
                        }

                        404 -> { //Not found
                            Log.e("HttpException", "${e.code()}: ${e.message}")
                            //Do something
                        }

                        500 -> { //Internal Server Error
                            Log.e("HttpException", "${e.code()}: ${e.message}")
                            //Do something
                        }
                    }
                }
            }
        }
    }

    fun filterCharacters(name: String) {

        val characters = _state.value.characters
        val filteredCharacter = characters.filter { name == it.name }

        _state.value = _state.value.copy(filteredCharacters = filteredCharacter)

    }

    fun resetCharacters() {
        val characters = state.value.characters
        _state.value = _state.value.copy(filteredCharacters = characters)
    }
}

//unsuccessful character response
//e.localizedMessage?.let { Log.e("Unsuccessful response", it) }

