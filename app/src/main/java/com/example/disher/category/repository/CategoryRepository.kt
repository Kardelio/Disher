package com.example.disher.category.repository

import com.example.disher.category.model.CategoryResponse
import com.example.disher.category.service.ICategoryService
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    val service: ICategoryService
) : ICategoryRepository{
    override suspend fun getAllCategories(): CategoryResponse {
        return service.getAllCategories()
    }
}