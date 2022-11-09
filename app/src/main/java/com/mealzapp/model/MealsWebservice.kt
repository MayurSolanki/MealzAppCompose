package com.mealzapp.model

import com.mealzapp.model.MealsCategoriesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface MealsWebservice  {
        @GET(value = "categories.php")
        suspend fun getMeals() : Response<MealsCategoriesResponse>
}

