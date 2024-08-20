package com.example.myrecipeapp.ui.theme

sealed class Screen(val route :String){
    object RecipeScreen:Screen("recipescreen")
    object DetailScreen:Screen("detailscreen")
}