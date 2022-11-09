package com.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.mealzapp.model.MealResponse
import com.mealzapp.model.MealsRepository

class MealCategoriesViewModel(private val repository: MealsRepository = MealsRepository()): ViewModel() {

     fun getMeals(): List<MealResponse>{
         return repository.getMeals()?.categories.orEmpty()
     }

    override fun onCleared() {
        super.onCleared()
    }
}