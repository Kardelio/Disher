package com.example.disher.category.repository

import com.example.disher.category.model.CategoryResponse
import com.example.disher.category.service.ICategoryService
import com.example.disher.db.DisherDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ICategoryRepository {
    suspend fun getAllCategories(): CategoryResponse
}

class CategoryRepository @Inject constructor(
    val service: ICategoryService,
    val dao: DisherDao,
    val dispatcher: CoroutineDispatcher
) : ICategoryRepository {
    override suspend fun getAllCategories(): CategoryResponse {
        return withContext(dispatcher) {
            val response = try {
                val hold = service.getAllCategories()
                dao.saveCategoryResponse(hold.categories)
                hold
            } catch (e: Exception) {
                CategoryResponse(dao.getAllCategories())
            }
            response
        }
    }
}