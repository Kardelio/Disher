package com.example.disher.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.disher.detail.model.SmallerMeal

@Dao
interface DisherDao {

    @Query("SELECT * FROM meal_details")
    suspend fun getListOfString(): List<SmallerMeal>

    @Insert(onConflict = REPLACE)
    suspend fun saveMeal(meal: SmallerMeal)

}