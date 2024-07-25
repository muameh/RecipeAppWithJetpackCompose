package com.mehmetbaloglu.recipeappwithjetpackcompose

data class Category(
    var idCategory: String,
    var strCategory: String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
)

data class CateroiesResponse(val categories: List<Category>)

data class RecipeState(
    val loading: Boolean = true,
    val error: String? = null,
    val list: List<Category> = emptyList()
)
