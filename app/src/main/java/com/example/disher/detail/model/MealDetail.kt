package com.example.disher.detail.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_details")
data class SmallerMeal(
    @PrimaryKey
    val idMeal: String,
    val title: String
)

fun MealDetail.convertToSmaller(): SmallerMeal {
    return SmallerMeal(this.idMeal, this.strMeal)
}

data class MealDetail(
    val dateModified: String,
    val idMeal: String,
    val strArea: String,
    val strCategory: String,
    val strCreativeCommonsConfirmed: String,
    val strDrinkAlternate: String,
    val strImageSource: String,
    val strIngredient1: String,
    val strIngredient10: String,
    val strIngredient11: String,
    val strIngredient12: String,
    val strIngredient13: String,
    val strIngredient14: String,
    val strIngredient15: String,
    val strIngredient16: String,
    val strIngredient17: String,
    val strIngredient18: String,
    val strIngredient19: String,
    val strIngredient2: String,
    val strIngredient20: String,
    val strIngredient3: String,
    val strIngredient4: String,
    val strIngredient5: String,
    val strIngredient6: String,
    val strIngredient7: String,
    val strIngredient8: String,
    val strIngredient9: String,
    val strInstructions: String,
    val strMeal: String,
    val strMealThumb: String,
    val strMeasure1: String,
    val strMeasure10: String,
    val strMeasure11: String,
    val strMeasure12: String,
    val strMeasure13: String,
    val strMeasure14: String,
    val strMeasure15: String,
    val strMeasure16: String,
    val strMeasure17: String,
    val strMeasure18: String,
    val strMeasure19: String,
    val strMeasure2: String,
    val strMeasure20: String,
    val strMeasure3: String,
    val strMeasure4: String,
    val strMeasure5: String,
    val strMeasure6: String,
    val strMeasure7: String,
    val strMeasure8: String,
    val strMeasure9: String,
    val strSource: String,
    val strTags: String,
    val strYoutube: String
)
