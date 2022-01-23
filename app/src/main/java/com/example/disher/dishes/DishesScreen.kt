package com.example.disher.dishes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.disher.category.model.Dish

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun DishesScreen(
    modifier: Modifier = Modifier,
    dishes: List<Dish>
) {
    Dishes(
        modifier = modifier,
        dishes = dishes,
        onClick = { /* no-op */ }
    )
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
private fun Dishes(
    modifier: Modifier = Modifier,
    dishes: List<Dish>,
    onClick: (Dish) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(
            items = dishes,
            key = { dish: Dish -> dish.hashCode() }
        ) { dish ->
            Dish(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                dish = dish,
                onClick = onClick
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
private fun Dish(
    modifier: Modifier = Modifier,
    dish: Dish,
    onClick: (Dish) -> Unit
) {
    Card(
        modifier = modifier,
        onClick = { onClick(dish) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                painter = rememberImagePainter(dish.strMealThumb),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = dish.strMeal)
        }
    }
}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
private fun DishesPreview() {
    Dishes(
        modifier = Modifier.fillMaxSize(),
        dishes = listOf(
            Dish(
                idMeal = "1",
                strMeal = "Meal-1",
                strMealThumb = ""
            ),
            Dish(
                idMeal = "2",
                strMeal = "Meal-2",
                strMealThumb = ""
            ),
            Dish(
                idMeal = "3",
                strMeal = "Meal-3",
                strMealThumb = ""
            )
        ),
        onClick = { /* no-op */ }
    )
}
