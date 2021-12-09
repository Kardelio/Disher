package com.example.disher.dishes.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "dishes")
data class Meal(
    @PrimaryKey
    val idMeal: String,
    var categoryId: String,
    val strMeal: String,
    val strMealThumb: String
)