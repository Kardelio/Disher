package com.example.disher.dishes.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.dishes.model.Meal
import com.example.disher.dishes.usecase.IGetDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class ViewState {
    object Loading : ViewState()
    data class Success(val data: List<Meal>) : ViewState()
    data class Error(val errorMessage: String) : ViewState()
}

@HiltViewModel
class DishesViewModel @Inject constructor(
    val usecase: IGetDishesUseCase
) : ViewModel() {

    private val _viewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val viewState: State<ViewState> = _viewState

    fun getDishesForCategory(catName: String) {
        _viewState.value = ViewState.Loading
        viewModelScope.launch {
            try {
                val listDishes = usecase(catName)
                _viewState.value = ViewState.Success(listDishes.meals)
            } catch (e: Exception) {
                Log.d("BK", "Exception ${e.message}")
                _viewState.value = ViewState.Error(e.message ?: "Unknown error sad times")
            }
        }
    }

}