package com.example.yinyummy.data.retrofit

import com.example.yinyummy.model.FoodRecipe
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val foodRecipeApi: FoodRecipeApi) {

    suspend fun getAllRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipeApi.getAllRecipes(queries)
    }

    suspend fun getRecipesByCuisine(queries: Map<String, String>):FoodRecipe {
        return foodRecipeApi.getRecipesByCuisine(queries)
    }

    fun getRandomRecipes(queries: Map<String,String>): Call<FoodRecipe> {
        return foodRecipeApi.getRandomRecipes(queries)
    }

}