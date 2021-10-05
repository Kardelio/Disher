package com.example.disher.category.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.disher.category.model.Dish
import com.example.disher.category.repository.DishRepository
import com.example.disher.category.usecase.IDishesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(useCase: IDishesUseCase) : ViewModel() {

    private val _listOfDish: MutableState<List<Dish>> = mutableStateOf(emptyList())
    val listOfDish: State<List<Dish>> = _listOfDish
    val useCase = useCase


    fun getAllDish(selectedCategory: String){
        viewModelScope.launch {
            val dishList = useCase(selectedCategory)
            _listOfDish.value = dishList.meals
        }
    }

}