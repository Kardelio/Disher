package com.example.disher.detail

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.detail.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    viewmodel: DetailViewModel = hiltViewModel(),
    mealId: String?
) {

    //SIDE EFFECT
    DisposableEffect(key1 = Unit) {
        if (!mealId.isNullOrBlank()) {
            viewmodel.getDetailsForDishId(mealId)
        }
        onDispose { }
    }

    val singleDish by remember { viewmodel.meal }
    //colelct the state
    //
    singleDish?.let {
        Text(it.strMeal)
    }
}
