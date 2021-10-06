package com.example.disher.dishes.service

import com.example.disher.dishes.model.DishesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IDishesService {

    @GET("filter.php")
    suspend fun getDishesForCategory(
        @Query("c") categoryName: String
    ): DishesResponse
}