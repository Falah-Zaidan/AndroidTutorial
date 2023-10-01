package com.example.tutorialapplication.viewmodel

import com.example.tutorialapplication.MainDispatcherRule
import com.example.tutorialapplication.api.HPService
import com.example.tutorialapplication.util.ValidCharacterData
import com.example.tutorialapplication.util.serializeCharacterData
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CharacterViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()

    private lateinit var viewModel: CharacterViewModel
    private var service: HPService = mock()

    @Before
    fun setUp() {
        viewModel = CharacterViewModel(service)
    }

    @Test
    fun getCharacters() = runTest {

        val characterResponse = serializeCharacterData(ValidCharacterData.data)

        whenever(service.getCharacters()).thenReturn(characterResponse)

        viewModel.getCharacters()
        assert(viewModel.state.value.characters.isNotEmpty())
    }

}















