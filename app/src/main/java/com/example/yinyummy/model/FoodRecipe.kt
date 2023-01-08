package com.example.yinyummy.model


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class FoodRecipe(
    @SerializedName("number")
    val number: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("totalResults")
    val totalResults: Int
)