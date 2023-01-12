package com.example.yinyummy.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "extendedIngredient")
data class ExtendedIngredient(
    @SerializedName("aisle")
    val aisle: String?,
    @SerializedName("amount")
    val amount: Double?,
    @SerializedName("consistency")
    val consistency: String?,
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("nameClean")
    val nameClean: String?,
    @SerializedName("original")
    val original: String?,
    @SerializedName("originalName")
    val originalName: String?,
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("result_id")
    var resultId : Int?
)