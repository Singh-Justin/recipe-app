package com.example.recipeapp

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable

@Composable
fun CategoryList(categories: List<Category>) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}