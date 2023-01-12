package com.example.yinyummy.repository

import com.example.yinyummy.model.MissedIngredient
import kotlinx.coroutines.flow.Flow

interface MissedIngredientRepository {

    suspend fun getAllMissIngredient(): Flow<MissedIngredient>

    suspend fun insertMissIngredient(missedIngredient: List<MissedIngredient>)

}