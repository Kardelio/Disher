package com.example.disher.dishes

import android.util.Log
import androidx.compose.runtime.Composable

private const val TAG = "DishesScreen"

@Composable
fun DishesScreen(
    selectedCategory: String
) {
    Log.d(TAG, "Selected Category: $selectedCategory")
}