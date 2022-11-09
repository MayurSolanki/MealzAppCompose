package com.mealzapp.ui.meals

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.mealzapp.model.MealResponse
import com.mealzapp.model.MealsCategoriesResponse
import com.mealzapp.model.MealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Response

class MealCategoriesViewModel(): ViewModel() {

    private val repository: MealsRepository = MealsRepository()

    init {
       // getMealsInfo()
    }
//    var meals = liveData<Response<MealsCategoriesResponse>> {
//        val rcvdAlbum : Response<MealsCategoriesResponse> = repository.getMealData()
//        Log.d("rcvdAlbum", rcvdAlbum.toString())
//        emit(rcvdAlbum)
//    }
    fun getMealsInfo() {
        viewModelScope.launch {
            repository.getMealData()
                .flowOn(Dispatchers.IO)
                .collect {
                     Log.d("getMealsInfo : ", it.body()?.categories?.get(1).toString())
                }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}