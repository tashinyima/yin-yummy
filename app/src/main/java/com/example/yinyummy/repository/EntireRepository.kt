package com.example.yinyummy.repository

interface EntireRepository {

    suspend fun getAllRecipe(queries: Map<String, String>): Boolean

}