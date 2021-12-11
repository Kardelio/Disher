package com.example.disher.navigation

sealed class Screen(val route: String) {
    object Category: Screen(route = "category")
    object Dishes: Screen(route = "dishes") {
        const val CATEGORY = "category"
    }
    object DishDetail: Screen(route = "dish_detail")
}