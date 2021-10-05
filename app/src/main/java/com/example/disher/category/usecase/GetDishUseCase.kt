package com.example.disher.category.usecase

import com.example.disher.category.model.DishResponse
import com.example.disher.category.repository.DishRepository
import javax.inject.Inject

interface IDishesUseCase{
    suspend operator fun invoke(selectedCategory: String): DishResponse
}

class GetDishUseCase @Inject constructor(private val repo: DishRepository ): IDishesUseCase{
    override suspend fun invoke(selectedCategory: String): DishResponse {
        return repo.getAllMeals(selectedCategory)
    }
}