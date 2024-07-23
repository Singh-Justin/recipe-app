package com.example.recipeapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CategoriesScreen(modifier: Modifier = Modifier) {
    val categoryViewModel: CategoryViewModel = viewModel()
    val categoryState by categoryViewModel.state

    Box(modifier = modifier.fillMaxSize()) {

        if (categoryState.isLoading) return CircularProgressIndicator(modifier.align(Alignment.Center))
        if (categoryState.isError) return Text("ERROR OCCURRED ${categoryState.error?.message}")

        return CategoryList(categoryState.data)
    }
}