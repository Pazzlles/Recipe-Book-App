package com.example.recipebook.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.recipebook.model.Recipe
import com.example.recipebook.model.toReadable

@Composable
fun RecipeItem(recipe: Recipe, onClick: () -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(recipe.title)
            Text("${recipe.category} • ${recipe.time} min • ${recipe.difficulty}")
            Text("State: ${recipe.state.toReadable()}")
        }
    }
}