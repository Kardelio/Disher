package com.example.disher.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.disher.detail.model.SmallerMeal

@Database(
    entities = [SmallerMeal::class],
    version = 1,
    exportSchema = false
)
abstract class DisherDatabase : RoomDatabase() {

    abstract fun provideDao(): DisherDao

}