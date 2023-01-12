package com.example.yinyummy.repository

import kotlinx.coroutines.flow.Flow
import com.example.yinyummy.model.Result


interface ResultRepository {

    suspend fun getAllResult(): Flow<List<Result>>
    suspend fun insertResult(result: List<Result>)
    suspend fun getResultById(id: Int): Result
}