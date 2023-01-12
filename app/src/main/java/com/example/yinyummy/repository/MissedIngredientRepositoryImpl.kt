package com.example.yinyummy.repository

import com.example.yinyummy.data.database.dao.MissedIngredientDao
import com.example.yinyummy.model.MissedIngredient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MissedIngredientRepositoryImpl @Inject constructor(private val miDao: MissedIngredientDao): MissedIngredientRepository {
    override suspend fun getAllMissIngredient(): Flow<MissedIngredient> {
        return miDao.getAllMissIngredient()
    }

    override suspend fun insertMissIngredient(missedIngredient: List<MissedIngredient>) {
        miDao.insertMissIngredient(missedIngredient)
    }
}