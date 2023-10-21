package com.example.tutorialapplication

import com.example.tutorialapplication.api.HPService
import com.example.tutorialapplication.viewmodel.CharacterViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var characterViewModel: CharacterViewModel
    private val service: HPService = mock()

    @Before
    fun setUp() {
        characterViewModel = CharacterViewModel(service)
    }

    @Test
    fun getCharactersTest() = runTest {

        val characterList = serializeCharacterData(CharacterData.data)

        whenever(service.getCharacters()).thenReturn(characterList)


        characterViewModel.getCharacters() // don't really need to call it because 'getCharacters() launched when ViewModel is initialised

        assert(characterViewModel.state.value.characters == characterList)


    }

}