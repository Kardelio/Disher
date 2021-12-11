package com.example.disher.category.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.category.model.Dish
import com.example.disher.category.usecase.IDishesUseCase
import com.example.disher.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val useCase: IDishesUseCase
) : ViewModel() {

    private val _listOfDish: MutableState<List<Dish>> = mutableStateOf(emptyList())
    val listOfDish: State<List<Dish>> = _listOfDish

    init {
        savedStateHandle.get<String>(Screen.Dishes.CATEGORY)?.let {
            getAllDish(it)
        }
    }

    private fun getAllDish(selectedCategory: String){
        viewModelScope.launch {
            val dishList = useCase(selectedCategory)
            _listOfDish.value = dishList.meals
        }
    }

}