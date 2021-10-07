package com.example.disher.dishes

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.disher.category.viewmodel.DishViewModel

private const val TAG = "DishesScreen"

@Composable
fun DishesScreen(
    selectedCategory: String,
    viewModel: DishViewModel = hiltViewModel()
) {

    viewModel.getAllDish(selectedCategory = selectedCategory)
    Text(text = viewModel.listOfDish.value.toString())


}