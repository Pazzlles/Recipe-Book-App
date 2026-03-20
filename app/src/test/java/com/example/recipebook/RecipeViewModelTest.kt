package com.example.recipebook

import com.example.recipebook.model.*
import com.example.recipebook.viewmodel.RecipeViewModel
import org.junit.Assert.*
import org.junit.Test

class RecipeViewModelTest {

    private val viewModel = RecipeViewModel()

    @Test
    fun searchWorks() {
        val result = viewModel.filterRecipes(sampleRecipes, "Pasta", "All")
        assertEquals(1, result.size)
    }

    @Test
    fun filterWorks() {
        val result = viewModel.filterRecipes(sampleRecipes, "", "Italian")
        assertTrue(result.all { it.category == "Italian" })
    }

    @Test
    fun updateStateWorks() {
        viewModel.updateState(1, RecipeState.COOKED)
        val recipe = viewModel.getRecipeById(1)
        assertEquals(RecipeState.COOKED, recipe?.state)
    }
}