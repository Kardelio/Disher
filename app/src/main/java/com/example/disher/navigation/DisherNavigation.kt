package com.example.disher.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.disher.category.CategoryScreen
import com.example.disher.dishes.DishesScreen
import com.example.disher.navigation.Screen.*

@Composable
fun DisherNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Category.route) {
        composable(
            route = Category.route
        ) {
            CategoryScreen(
                onCategoryClick = { selectedCategory ->
                    navController.navigate("${Dishes.route}/$selectedCategory")
                }
            )
        }

        composable(
            route = "${Dishes.route}/{${Dishes.CATEGORY}}",
            arguments = listOf(navArgument(Dishes.CATEGORY) { type = NavType.StringType })
        ) {
            DishesScreen()
        }

        composable(route = DishDetail.route) {
            /*
               like Dishes composable, we can set key and arguments here
               for the lookup api where we need a unique dish id.
            */
        }
    }
}