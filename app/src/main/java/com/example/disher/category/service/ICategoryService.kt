package com.example.disher.category.service

import com.example.disher.category.model.CategoryResponse
import retrofit2.http.GET

interface ICategoryService {

    @GET("categories.php")
    suspend fun getAllCategories(): CategoryResponse

}


//www.themealdb.com/api/json/v1/1/categories.php