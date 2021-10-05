package com.example.disher.category.repository

import com.example.disher.category.model.DishResponse
import com.example.disher.category.service.IDishService
import javax.inject.Inject


interface IDishRepository{
    suspend fun getAllMeals(dishCategory: String): DishResponse
}

class DishRepository @Inject constructor(val service: IDishService): IDishRepository{
    override suspend fun getAllMeals(dishCategory: String): DishResponse {
        return service.getAllMeals(dishCategory)
    }
}