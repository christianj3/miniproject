package com.example.androidtechnicalproject.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidtechnicalproject.R
import com.example.androidtechnicalproject.databinding.MealsItemBinding
import com.example.androidtechnicalproject.model.Meals



class MealsAdapter(val mView: MealsView) : RecyclerView.Adapter<MealsAdapter.MealsViewHolder>() {

    private val mTransactions = mutableListOf<Meals>()

    fun initialize(meals: List<Meals>){
        this.mTransactions.clear()
        this.mTransactions.addAll(meals)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MealsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MealsViewHolder(MealsItemBinding.inflate(inflater, parent,false)
        )
    }

    override fun getItemCount(): Int {
        return mTransactions.size
    }

    override fun onBindViewHolder(p0: MealsViewHolder, position: Int) {
        p0.bind(mTransactions[position], mView, position)
    }

    class MealsViewHolder(val binding: MealsItemBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(m: Meals, view: MealsView, position: Int){
            binding.containerMeals.setOnClickListener {
                view.onShowMealDetails(m)
            }

            binding.tvTitle.text = m.strCategory
            binding.tvDescription.text = m.strCategoryDescription
            binding.ivPic.load(m.strCategoryThumb) {
                crossfade(true)
                placeholder(R.drawable.ic_launcher_foreground)
                transformations(CircleCropTransformation())
            }

        }
    }
}