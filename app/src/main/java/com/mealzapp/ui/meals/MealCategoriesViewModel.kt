package com.mealzapp.ui.meals

import android.util.Log
import androidx.lifecycle.*
import com.mealzapp.model.MealResponse
import com.mealzapp.model.MealsCategoriesResponse
import com.mealzapp.model.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response

class MealCategoriesViewModel(): ViewModel() {

    private val repository: MealsRepository = MealsRepository()

    private val _meals: MutableStateFlow<List<MealResponse>?> = MutableStateFlow(null)
    val meals = _meals.asStateFlow()

//    private val _meals: MutableStateFlow<List<MealResponse>> =
//        MutableStateFlow(emptyList())
//    val meals: MutableStateFlow<List<MealResponse>> = _meals

    init {
        getMealsInfo()
    }


    private fun getMealsInfo() {
        viewModelScope.launch {
            repository.getMealData()
                .flowOn(Dispatchers.IO)
                .collect {
                    _meals.value = it.body()?.categories
                    // Log.d("getMealsInfo : ", it.body()?.categories?.get(1).toString())
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}