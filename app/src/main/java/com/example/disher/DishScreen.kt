package com.example.disher

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

data class Dish(val strMeal: String, val strMealThumb: String, val idMeal: Int)

@Composable
fun DisplayDishes(dishes: List<Dish>) {
    LazyColumn {
        items(dishes) { dish ->
            DisplayDish(dish = dish)

        }
    }
}


@Composable
fun DisplayDish(dish: Dish) {
    Card(
        shape = RoundedCornerShape(10.dp), elevation = 5.dp, modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Image(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                painter = rememberImagePainter(dish.strMealThumb),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = dish.strMeal, fontSize = 24.sp)
        }
    }

}