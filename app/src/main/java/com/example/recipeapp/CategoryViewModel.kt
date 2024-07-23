package com.example.recipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class CategoryState(
    val isLoading: Boolean = true,
    val data: List<Category> = emptyList(),
    val isError: Boolean = false,
    val error: Exception? = null
)


class CategoryViewModel: ViewModel() {
    val state = mutableStateOf(CategoryState())

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = apiService.getCategories()

                state.value = state.value.copy(
                    data = response.categories,
                    isLoading = false,
                    error = null,
                    isError = false,
                )
            }
            catch (e: Exception) {
                state.value = state.value.copy(
                    data = emptyList(),
                    isLoading = false,
                    error = e,
                    isError = true,
                )
            }
        }
    }

    init{
        fetchCategories()
    }

}