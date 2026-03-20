package com.example.recipebook.ui

import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipebook.model.*
import com.example.recipebook.viewmodel.RecipeViewModel

@Composable
fun RecipeDetailScreen(
    navController: NavController,
    viewModel: RecipeViewModel,
    recipeId: Int
) {

    val recipe = viewModel.getRecipeById(recipeId)

    recipe?.let { r ->

        var expanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

            Text(r.title, style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(8.dp))

            Text("Описание:", style = MaterialTheme.typography.titleMedium)
            Text(r.description)

            Spacer(Modifier.height(8.dp))

            Text("Ингредиенты:", style = MaterialTheme.typography.titleMedium)
            r.ingredients.forEach { Text("• $it") }

            Spacer(Modifier.height(8.dp))

            Text("Шаги:", style = MaterialTheme.typography.titleMedium)
            Text(r.steps)

            Spacer(Modifier.height(8.dp))

            Text("Время: ${r.time} мин")
            Text("Сложность: ${r.difficulty}")
            Text("Статус: ${r.state.toReadable()}")

            Spacer(Modifier.height(16.dp))

            Button(onClick = { expanded = true }) {
                Text("Изменить статус")
            }

            DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                RecipeState.values().forEach { state ->
                    DropdownMenuItem(
                        text = { Text(state.toReadable()) },
                        onClick = {
                            viewModel.updateState(r.id, state)
                            expanded = false
                        }
                    )
                }
            }

            Spacer(Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text("Назад")
            }
        }
    }
}