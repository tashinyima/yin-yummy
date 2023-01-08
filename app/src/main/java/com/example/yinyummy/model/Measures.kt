package com.example.yinyummy.model


import com.google.gson.annotations.SerializedName

data class Measures(
    @SerializedName("us")
    val us: Us
)