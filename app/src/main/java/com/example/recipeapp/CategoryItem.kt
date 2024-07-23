package com.example.recipeapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import coil.compose.AsyncImage
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun CategoryItem(category: Category) {

    Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        AsyncImage(
            model = category.strCategoryThumb,
            contentDescription = null,
        )

        Text(
            text = category.strCategory,
            modifier = Modifier.padding(top = 16.dp),
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
    }
}