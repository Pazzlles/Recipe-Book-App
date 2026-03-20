package com.example.recipebook

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.recipebook.navigation.AppNavigation
import org.junit.Rule
import org.junit.Test

class RecipeListScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun titleIsVisible() {
        composeTestRule.setContent {
            AppNavigation()
        }

        composeTestRule
            .onNodeWithText("Recipe Book")
            .assertIsDisplayed()
    }
}