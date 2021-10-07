package com.example.disher.category.service

import com.example.disher.category.model.DishResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishService {

    @GET("filter.php")
    suspend fun getAllMeals(@Query("c")  dishCategory: String?): DishResponse
}