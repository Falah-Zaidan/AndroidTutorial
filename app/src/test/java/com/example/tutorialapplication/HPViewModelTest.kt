package com.example.tutorialapplication

import com.example.tutorialapplication.util.MainDispatcherRule
import com.example.tutorialapplication.api.HPService
import com.example.tutorialapplication.util.ValidCharacterData
import com.example.tutorialapplication.util.ValidSpellData
import com.example.tutorialapplication.util.serializeCharacterData
import com.example.tutorialapplication.util.serializeSpellData
import com.example.tutorialapplication.viewmodel.HPViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HPViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainDispatcherRule()

    private lateinit var viewModel: HPViewModel
    private var service: HPService = mock()

    @Before
    fun setUp() {
        viewModel = HPViewModel(service)
    }

    @Test
    fun testGetCharacters() = runTest {

        val characterResponse = serializeCharacterData(ValidCharacterData.data)

        whenever(service.getCharacters()).thenReturn(characterResponse)

        viewModel.getCharacters()
        assert(viewModel.state.value.characters == characterResponse)
    }

    @Test
    fun testGetSpells() = runTest {

        val spellResponse = serializeSpellData(ValidSpellData.data)

        whenever(service.getSpells()).thenReturn(spellResponse)

        viewModel.getSpells()
        assert(viewModel.state.value.spells == spellResponse)
    }

}















