package com.example.disher.di

import com.example.disher.category.repository.CategoryRepository
import com.example.disher.category.repository.ICategoryRepository
import com.example.disher.category.service.ICategoryService
import com.example.disher.category.usecase.GetCategoriesUseCase
import com.example.disher.category.usecase.IGetCategoriesUseCase
import com.example.disher.detail.repository.DetailRepository
import com.example.disher.detail.repository.IDetailRepository
import com.example.disher.detail.service.IDetailService
import com.example.disher.detail.usecase.GetDetailsUseCase
import com.example.disher.detail.usecase.IGetDetailsUseCase
import com.example.disher.dishes.repository.DishesRepository
import com.example.disher.dishes.repository.IDishesRepository
import com.example.disher.dishes.service.IDishesService
import com.example.disher.dishes.usecase.GetDishesUseCase
import com.example.disher.dishes.usecase.IGetDishesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesCategoryService(retrofit: Retrofit): ICategoryService {
        return retrofit.create(ICategoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideDishesService(retrofit: Retrofit): IDishesService {
        return retrofit.create(IDishesService::class.java)
    }

    @Provides
    @Singleton
    fun provideDetailService(retrofit: Retrofit): IDetailService {
        return retrofit.create(IDetailService::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface AppModuleInt {

        @Binds
        @Singleton
        fun provideDishesRepository(repo: DishesRepository): IDishesRepository

        @Binds
        @Singleton
        fun provideGetDishesUseCase(uc: GetDishesUseCase): IGetDishesUseCase

        @Binds
        @Singleton
        fun provideDetailRepo(repo: DetailRepository): IDetailRepository

        @Binds
        @Singleton
        fun provideGetDetailUseCase(uc: GetDetailsUseCase): IGetDetailsUseCase

        @Binds
        @Singleton
        fun provideCategoryRepository(repo: CategoryRepository): ICategoryRepository

        @Binds
        @Singleton
        fun provideGetCategoryUseCase(uc: GetCategoriesUseCase): IGetCategoriesUseCase
    }

}