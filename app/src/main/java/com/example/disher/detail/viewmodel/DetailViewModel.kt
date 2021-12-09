package com.example.disher.detail.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.db.DisherDao
import com.example.disher.detail.model.MealDetail
import com.example.disher.detail.model.convertToSmaller
import com.example.disher.detail.usecase.IGetDetailsUseCase
import com.example.disher.dishes.viewmodel.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    val usecase: IGetDetailsUseCase,
    val dao: DisherDao
) : ViewModel() {

    private val _meal: MutableState<MealDetail?> = mutableStateOf(null)
    val meal: State<MealDetail?> = _meal

    //TODO
    fun getDetailsForDishId(id: String) {
        Log.d("BK", "$id")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val mealDetailResponse = usecase(id)
                Log.d("BK", "${mealDetailResponse.meals[0].strMeal}")
                val meal = mealDetailResponse.meals[0]
                //TODO combine saved favourites too...
                _meal.value = meal
            } catch (e: Exception) {
                Log.d("BK", "Exception ${e.message}")
            }
        }
    }

    fun saveToFavourites(mealDetail: MealDetail){
       viewModelScope.launch {
           dao.saveMeal(mealDetail.convertToSmaller())
       }
    }

}