package com.mealzapp.model

import com.mealzapp.model.api.MealsWebservice

class MealsRepository (private val webservice: MealsWebservice = MealsWebservice()) {
    fun getMeals(): MealsCategoriesResponse? {
        return webservice.getMeals().execute().body()
    }
}