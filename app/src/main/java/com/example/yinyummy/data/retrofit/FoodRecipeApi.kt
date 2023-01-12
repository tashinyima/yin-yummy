package com.example.yinyummy.data.retrofit

import com.example.yinyummy.model.FoodRecipe
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipeApi {
    @GET("/recipes/complexSearch")
    suspend fun getAllRecipes(@QueryMap allQueries: Map<String, String>): Response<FoodRecipe>

    @GET("/recipes/complexSearch")
    suspend fun getRecipesByCuisine(@QueryMap allQueries: Map<String, String>): FoodRecipe

    @GET("/recipes/complexSearch")
    fun getRandomRecipes(@QueryMap queries: Map<String, String>): Call<FoodRecipe>


}