package com.example.disher.dishes

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.dishes.viewmodel.DishesViewModel
import com.example.disher.dishes.viewmodel.ViewState

@Composable
fun DishesScreen(
    viewmodel: DishesViewModel = hiltViewModel(),
    category: String?
) {

    DisposableEffect(key1 = Unit) {
        if (!category.isNullOrBlank()) {
            viewmodel.getDishesForCategory(category)
        }
        onDispose {}
    }

    val viewState by remember { viewmodel.viewState }

    when (val state = viewState) {
        is ViewState.Success -> {
            Text(text = "Success ${state.data}")
        }
        is ViewState.Error -> {
            Text(text = "Error:  ${state.errorMessage}")
        }
        else -> {
            Text(text = "Loading")
        }
    }

}