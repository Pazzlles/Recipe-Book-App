package com.example.recipebook.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.recipebook.model.*

class RecipeViewModel : ViewModel() {

    private val _recipes = mutableStateListOf<Recipe>().apply {
        addAll(sampleRecipes)
    }

    var searchQuery by mutableStateOf("")
    var selectedFilter by mutableStateOf("Все")

    val recipes: List<Recipe>
        get() = _recipes.filter {
            it.title.contains(searchQuery, true) &&
                    (selectedFilter == "Все" || it.category == selectedFilter)
        }

    fun updateState(recipeId: Int, newState: RecipeState) {
        _recipes.find { it.id == recipeId }?.state = newState
    }

    fun getRecipeById(id: Int): Recipe? {
        return _recipes.find { it.id == id }
    }

    fun getStats(): String {
        val cooked = _recipes.count { it.state == RecipeState.COOKED }
        return "$cooked / ${_recipes.size}"
    }
}