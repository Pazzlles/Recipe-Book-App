package com.example.recipebook.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.recipebook.ui.*
import com.example.recipebook.viewmodel.RecipeViewModel

@Composable
fun AppNavigation(viewModel: RecipeViewModel = viewModel()) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            RecipeListScreen(navController, viewModel)
        }

        composable("details/{recipeId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("recipeId")?.toInt() ?: 0
            RecipeDetailScreen(navController, viewModel, id)
        }
    }
}