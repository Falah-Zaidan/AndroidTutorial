package com.example.tutorialapplication

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.rememberNavController
import com.example.tutorialapplication.screens.ListScreen
import com.example.tutorialapplication.ui.theme.TutorialApplicationTheme
import com.example.tutorialapplication.util.ValidCharacterData
import com.example.tutorialapplication.util.serializeCharacterData
import com.example.tutorialapplication.viewmodel.State
import org.junit.Before
import org.junit.Test
import org.junit.Rule

//class CharacterListScreenTest {
//
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    private val characterData = serializeCharacterData(ValidCharacterData.data)
//
//    @Before
//    fun setUp() {
//        composeTestRule.setContent {
//            TutorialApplicationTheme {
//                val navController = rememberNavController()
//
//                val state = State(
//                    characters = characterData.toMutableList()
//                )
//
//                ListScreen(
//                    state = state,
//                    navController = navController
//                )
//            }
//        }
//    }
//
//    @Test
//    fun areCharactersShown() {
//        //Pick the Start/Middle/Last item, scroll to them and check that they exist on the screen
//
//        val firstCharacter = characterData.first()
//        val middleCharacter = characterData[characterData.size/2]
//        val lastCharacter = characterData.last()
//
//        composeTestRule.onNodeWithTag("character_list").performScrollToNode(hasText(firstCharacter.name!!))
//        composeTestRule.onNodeWithText(firstCharacter.name!!).assertIsDisplayed()
//
//        composeTestRule.onNodeWithTag("character_list").performScrollToNode(hasText(middleCharacter.name!!))
//        composeTestRule.onNodeWithText(middleCharacter.name!!).assertIsDisplayed()
//
//        composeTestRule.onNodeWithTag("character_list").performScrollToNode(hasText(lastCharacter.name!!))
//        composeTestRule.onNodeWithText(lastCharacter.name!!).assertIsDisplayed()
//    }
//
//}