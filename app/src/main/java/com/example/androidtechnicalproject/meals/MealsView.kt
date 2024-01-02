package com.example.androidtechnicalproject.meals

import android.content.Context
import com.example.androidtechnicalproject.model.Meals

interface MealsView {
    fun onGetMeals(data: List<Meals>)
    fun getContext() : Context?
    fun onError(message : String)
    fun showLoading()
    fun hideLoading()
    fun onShowMealDetails(data: Meals)

}
