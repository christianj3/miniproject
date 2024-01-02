package com.example.androidtechnicalproject

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.androidtechnicalproject.databinding.ActivityMainBinding
import com.example.androidtechnicalproject.meals.MealsAdapter
import com.example.androidtechnicalproject.meals.MealsPresenter
import com.example.androidtechnicalproject.meals.MealsView
import com.example.androidtechnicalproject.model.Meals
import com.rogomi.atlasfx.common.ProgressBarHandler

class MainActivity : AppCompatActivity(), MealsView {

    private lateinit var mPresenter: MealsPresenter
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAdapter: MealsAdapter
    private lateinit var progressBarHandler: ProgressBarHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: ConstraintLayout = binding.root
        setContentView(view)

        mPresenter = MealsPresenter(this)
        progressBarHandler = ProgressBarHandler(this)
        initAdapter()
        initAction()
        mPresenter.getCategories()
    }

   private fun initAction(){
        binding.swipeRefreshLayout.setOnRefreshListener {
            mPresenter.getCategories()
        }
    }




    private fun initAdapter() {
        mAdapter =
            MealsAdapter(this)
        binding.rvList.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)
        binding.rvList.adapter = mAdapter
    }

    override fun onGetMeals(data: List<Meals>) {
        Log.d("mealsREsponse", data.toString())
        binding.swipeRefreshLayout.isRefreshing = false
        mAdapter.initialize(data)

    }

    override fun getContext(): Context? {
        return this
    }

    override fun onError(message: String) {
        Log.d("error", "show Dialog Message $message")
    }

    override fun showLoading() {
        progressBarHandler.showProgressDialog()
    }

    override fun hideLoading() {
        progressBarHandler.hideProgressDialog()
    }

    override fun onShowMealDetails(data: Meals) {

    }
}