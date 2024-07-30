package com.mehmetbaloglu.recipeappwithjetpackcompose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun RecipeApp(navController: NavHostController) {
    val recipeViewModel: MainViewModel = viewModel()
    val viewState by recipeViewModel.categoryState

    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route) {

        //Main Screen
        composable(route = Screen.RecipeScreen.route) {
            RecipeScreen(viewState = viewState, navigateToDetail = {
                navController.currentBackStackEntry?.savedStateHandle?.set("cat", it)
                navController.navigate(Screen.CategoryDetailScreen.route)

            })
        }

        //Detail Screen
        composable(route = Screen.CategoryDetailScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("cat")
                ?: Category("", "", "", "")
            CategoryDetailScreen(category)
        }
    }
}