package com.example.androidtechnicalproject.model

import androidx.annotation.Keep
import java.io.Serializable




@Keep
data class MealResponse(
   val categories: List<Meals>
): Serializable

@Keep
data class Meals(
    val idCategory: Int,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
): Serializable