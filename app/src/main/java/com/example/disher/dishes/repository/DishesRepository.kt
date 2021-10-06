package com.example.disher.dishes.repository

import com.example.disher.dishes.model.DishesResponse
import com.example.disher.dishes.service.IDishesService
import javax.inject.Inject


interface IDishesRepository {

    suspend fun getDishesForCategory(categoryName: String): DishesResponse

}

class DishesRepository @Inject constructor(
    val service: IDishesService
) : IDishesRepository {

    override suspend fun getDishesForCategory(categoryName: String): DishesResponse {
        return service.getDishesForCategory(categoryName)
    }

}