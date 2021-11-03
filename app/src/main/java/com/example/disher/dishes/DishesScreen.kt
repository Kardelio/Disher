package com.example.disher.dishes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.category.SingleItem
import com.example.disher.dishes.model.Meal
import com.example.disher.dishes.viewmodel.DishesViewModel
import com.example.disher.dishes.viewmodel.ViewState

@Composable
fun DishesScreen(
    viewmodel: DishesViewModel = hiltViewModel(),
    category: String?,
    onDishClick: (String) -> Unit
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
            DishesList(state.data, onDishClick)
        }
        is ViewState.Error -> {
            Text(text = "Error:  ${state.errorMessage}")
        }
        else -> {
            Text(text = "Loading")
        }
    }
}


@Composable
fun DishesList(meals: List<Meal>, onDishClick: (String) -> Unit) {
    LazyColumn {
        items(meals) { item ->
            SingleItem(title = item.strMeal, thumbnail = item.strMealThumb) {
                onDishClick(item.idMeal)
            }
        }
    }
}