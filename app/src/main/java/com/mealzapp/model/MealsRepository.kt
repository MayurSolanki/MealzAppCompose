package com.mealzapp.model

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MealsRepository  {

    var mealsWebservice: MealsWebservice = RetrofitInstance.mealRetrofitService

    suspend fun getMealData(): Flow<Response<MealsCategoriesResponse>> =
        flow {
                emit(mealsWebservice.getMeals())
        }


    suspend fun getMealDataDummy() = mealsWebservice.getMeals()


}