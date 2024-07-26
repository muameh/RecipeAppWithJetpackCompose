package com.mehmetbaloglu.recipeappwithjetpackcompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Category(
    var idCategory: String,
    var strCategory: String,
    var strCategoryThumb: String,
    var strCategoryDescription: String
) :Parcelable

data class CateroiesResponse(val categories: List<Category>)

data class RecipeState(
    val loading: Boolean = true,
    val error: String? = null,
    val list: List<Category> = emptyList()
)
