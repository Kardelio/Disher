package com.example.disher.category.usecase

import com.example.disher.category.model.CategoryResponse
import com.example.disher.category.repository.ICategoryRepository
import javax.inject.Inject

interface IGetCategoriesUseCase {
    suspend operator fun invoke(): CategoryResponse
}

class GetCategoriesUseCase @Inject constructor(
    val repo: ICategoryRepository
): IGetCategoriesUseCase {
    override suspend fun invoke(): CategoryResponse {
        return repo.getAllCategories()
    }
}