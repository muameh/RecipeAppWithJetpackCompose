package com.mehmetbaloglu.recipeappwithjetpackcompose

sealed class Screen (val route: String){
    object RecipeScreen: Screen("recipe_screen")
    object CategoryDetailScreen: Screen("detail_screen")

}