package com.example.recipebook.ui

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipebook.viewmodel.RecipeViewModel

@Composable
fun RecipeListScreen(navController: NavController, viewModel: RecipeViewModel) {

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text("Книга рецептов", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(12.dp))

        TextField(
            value = viewModel.searchQuery,
            onValueChange = { viewModel.searchQuery = it },
            label = { Text("Поиск") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Row {
            Button(onClick = { viewModel.selectedFilter = "Все" }) {
                Text("Все")
            }
            Spacer(Modifier.width(8.dp))
            Button(onClick = { viewModel.selectedFilter = "Итальянская" }) {
                Text("Итальянская")
            }
        }

        Spacer(Modifier.height(12.dp))

        Text("Приготовлено: ${viewModel.getStats()}")

        Spacer(Modifier.height(12.dp))

        LazyColumn {
            items(viewModel.recipes) { recipe ->
                RecipeItem(recipe) {
                    navController.navigate("details/${recipe.id}")
                }
            }
        }
    }
}