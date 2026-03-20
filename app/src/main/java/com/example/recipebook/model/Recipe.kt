package com.example.recipebook.model

enum class RecipeState {
    WANT_TO_COOK,
    COOKING,
    COOKED,
    ON_HOLD,
    ABANDONED
}

data class Recipe(
    val id: Int,
    val title: String,
    val description: String,
    val steps: String,
    val ingredients: List<String>,
    val category: String,
    val time: Int,
    val difficulty: String,
    var state: RecipeState
)

fun RecipeState.toReadable(): String = when (this) {
    RecipeState.WANT_TO_COOK -> "Хочу приготовить"
    RecipeState.COOKING -> "Готовлю"
    RecipeState.COOKED -> "Готово"
    RecipeState.ON_HOLD -> "Отложено"
    RecipeState.ABANDONED -> "Брошено"
}