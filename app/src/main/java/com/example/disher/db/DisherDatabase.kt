package com.example.disher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disher.category.model.Category
import com.example.disher.detail.model.SmallerMeal
import com.example.disher.dishes.model.Meal

@Database(
    entities = [SmallerMeal::class, Category::class, Meal::class],
    version = 1,
    exportSchema = false
)
abstract class DisherDatabase : RoomDatabase() {

    abstract fun provideDao(): DisherDao

}