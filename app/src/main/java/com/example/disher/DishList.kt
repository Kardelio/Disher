package com.example.disher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.disher.ui.theme.DisherTheme

class DishList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    //Sample List of dishes
                    val dishes = listOf<Dish>(
                        Dish(
                            "Baked salmon with fennel & tomatoes",
                            "https://www.themealdb.com/images/media/meals/1548772327.jpg",
                            52959
                        ),
                        Dish(
                            "Cajun spiced fish tacos",
                            "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg",
                            52819
                        ),
                        Dish(
                            "Escovitch Fish",
                            "https://www.themealdb.com/images/media/meals/1520084413.jpg",
                            52944
                        ),
                        Dish(
                            "Fish fofos",
                            "https://www.themealdb.com/images/media/meals/a15wsa1614349126.jpg",
                            53043
                        ),
                        Dish(
                            "Fish pie",
                            "https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg",
                            52802
                        ),
                        Dish(
                            "Fish Stew with Rouille",
                            "https://www.themealdb.com/images/media/meals/vptqpw1511798500.jpg",
                            52918
                        ),

                        )
                    DisplayDishes(dishes = dishes)
                }
            }
        }
    }
}


