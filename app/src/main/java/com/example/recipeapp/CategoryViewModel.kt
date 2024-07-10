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
    private val _state = mutableStateOf(CategoryState())

    fun getState() = _state

    private fun fetchCategories(){
        viewModelScope.launch {
            try{
                val response = apiService.getCategories()

                _state.value = _state.value.copy(
                    data = response.categories,
                    isLoading = false,
                    error = null,
                    isError = false,
                )
            }
            catch (e: Exception) {
                _state.value = _state.value.copy(
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