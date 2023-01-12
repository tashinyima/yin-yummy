package com.example.yinyummy.repository

import com.example.yinyummy.model.ExtendedIngredient
import kotlinx.coroutines.flow.Flow

interface ExtendedIngredientRepository {

    suspend  fun getExtendedIngredientByResultID(resultId: Int): Flow<List<ExtendedIngredient>>

    suspend fun getAllExtendedIngredient(): Flow<ExtendedIngredient>

    suspend fun insertResult(result: List<ExtendedIngredient>)
}