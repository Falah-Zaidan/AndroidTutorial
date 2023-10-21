package com.example.tutorialapplication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToNode
import androidx.navigation.compose.rememberNavController
import com.example.tutorialapplication.screens.ListScreen
import com.example.tutorialapplication.viewmodel.State
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    val characterList = serializeCharacterData(CharacterData.data)

    @Before
    fun setUp() {
        composeTestRule.setContent {
            val navController = rememberNavController()

            val state = State(
                characters = characterList,
                filteredCharacters = characterList
            )

            ListScreen(
                navController = navController,
                state = state,
                filterCharacters = {},
                resetCharacters = {})
        }
    }

    @Test
    fun testCharactersArePresentInList() {

        val firstCharacter = characterList.first()
        val middleCharacter = characterList.get(characterList.size / 2)
        val lastCharacter = characterList.last()

        composeTestRule.onNodeWithTag("character_list")
            .performScrollToNode(hasText(firstCharacter.name!!))
        composeTestRule.onNodeWithText(firstCharacter.name!!).assertIsDisplayed()

        composeTestRule.onNodeWithTag("character_list")
            .performScrollToNode(hasText(middleCharacter.name!!))
        composeTestRule.onNodeWithText(middleCharacter.name!!).assertIsDisplayed()

        composeTestRule.onNodeWithTag("character_list")
            .performScrollToNode(hasText(lastCharacter.name!!))
        composeTestRule.onNodeWithText(lastCharacter.name!!).assertIsDisplayed()

    }


}