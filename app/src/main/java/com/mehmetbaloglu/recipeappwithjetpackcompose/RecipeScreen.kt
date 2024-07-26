package com.mehmetbaloglu.recipeappwithjetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewState: MainViewModel.RecipeState,
                 navigateToDetail: (Category) -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading == true -> {
                CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(
                    text = viewState.error.toString(), modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                categoryScreen(category = viewState.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun categoryScreen(
    category: List<Category>,
    navigateToDetail: (Category) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(category) {
            CategoryItem(category = it, navigateToDetail)
        }
    }
}

//How each item looks like --- like card design in Xml
@Composable
fun CategoryItem(category: Category, navigateToDetail: (Category) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .clickable { navigateToDetail(category) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),   //counterpart of Glide-Picasso
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
        )
        Text(
            text = category.strCategory,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

