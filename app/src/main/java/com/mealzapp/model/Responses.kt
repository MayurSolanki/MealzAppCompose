package com.mealzapp.model

import com.google.gson.annotations.SerializedName

data class MealResponse(@SerializedName("idCategory")  val id: String,
                        @SerializedName("strCategory")  val name: String,
                        @SerializedName("strCategoryDescription")  val description: String,
                        @SerializedName("strCategoryThumb")  val imageUrl: String
)

data class MealsCategoriesResponse(val categories: List<MealResponse>)

