package com.example.disher.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.disher.category.CategoryScreen
import com.example.disher.category.viewmodel.DishViewModel
import com.example.disher.dishes.DishesScreen
import com.example.disher.navigation.Screen.*

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun DisherNavigation() {
    val navController = rememberNavController()

    val dishViewModel: DishViewModel = viewModel()

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
            route = "${Dishes.route}/{selectedCategory}",
            arguments = listOf(navArgument("selectedCategory") { type = NavType.StringType })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("selectedCategory")
                ?.let { category ->
                    dishViewModel.getAllDish(selectedCategory = category)
                    val dishes = dishViewModel.listOfDish.value

                    DishesScreen(
                        modifier = Modifier.padding(
                            horizontal = 25.dp,
                            vertical = 20.dp
                        ),
                        dishes = dishes
                    )
                }
        }

        composable(route = DishDetail.route) {
            /*
               like Dishes composable, we can set key and arguments here
               for the lookup api where we need a unique dish id.
            */
        }
    }
}