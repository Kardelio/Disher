package com.example.disher.navigation

sealed class Screen(val route: String) {
    object Category: Screen(route = "category")
    object Dishes: Screen(route = "dishes")
    object DishDetail: Screen(route = "dish_detail")
}