package com.example.yinyummy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yinyummy.R
import com.example.yinyummy.model.Categories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CategoryViewModel @Inject constructor() : ViewModel() {

   val categoriesLiveData = MutableLiveData<List<Categories>>()

    fun loadCategories() {

        val catBreakfast = Categories(1,"Breakfast",R.drawable.profile_img)
        val catDinner = Categories(2,"Meals",R.drawable.profile_img)
        val catLunch = Categories(3,"Pizza",R.drawable.profile_img)
        val catDessert = Categories(4,"Dessert",R.drawable.profile_img)
       val categoryList = arrayListOf<Categories>(catBreakfast,catDinner,catDessert,catLunch)
        categoriesLiveData.value =categoryList

    }


}