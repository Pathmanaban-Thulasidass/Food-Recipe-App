package com.example.myrecipeapp.ui.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModal : ViewModel(){

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState : State<RecipeState> = _categoriesState

    init {
        fetchCatergory()
    }

    private fun fetchCatergory()
    {
        viewModelScope.launch {
            try
            {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    list = response.categories,
                    loading = false,
                    error = null
                )
            }
            catch (e:Exception){
                _categoriesState.value = _categoriesState.value.copy(
                    loading = false,
                    error = "Error Fetching in ${e.message}"
                )
            }
        }
    }
    data class RecipeState(
        val loading : Boolean = true,
        val list : List<Category> = emptyList(),
        val error :String? = null
    )

}