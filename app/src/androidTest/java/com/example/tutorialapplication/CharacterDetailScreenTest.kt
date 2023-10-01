package com.example.tutorialapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.tutorialapplication.screens.DetailScreen
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme
import com.example.tutorialapplication.util.ValidCharacterData
import com.example.tutorialapplication.util.serializeCharacterData
import com.example.tutorialapplication.viewmodel.State
import org.junit.Before
import org.junit.Test
import org.junit.Rule

class CharacterDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val characterData = serializeCharacterData(ValidCharacterData.data)
    private val randomCharacter = characterData.random()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TutorialApplicationTheme {
                val state = State(
                    characters = characterData.toMutableList()
                )

                DetailScreen(
                    state = state,
                    characterId = randomCharacter.id
                )
            }
        }
    }

    @Test
    fun isCharacterShown() {
        composeTestRule.onNodeWithContentDescription("Character Image").assertIsDisplayed()
        composeTestRule.onNodeWithText(randomCharacter.name!!).assertIsDisplayed()
    }

}