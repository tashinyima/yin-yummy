package com.example.yinyummy.repository

import com.example.yinyummy.data.database.dao.ExtendedIngredientDao
import com.example.yinyummy.model.ExtendedIngredient
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExtendedIngredientRepositoryImpl @Inject constructor(private val eiDao: ExtendedIngredientDao) :
    ExtendedIngredientRepository {
    override suspend fun getExtendedIngredientByResultID(resultId: Int): Flow<List<ExtendedIngredient>> {
        return eiDao.getExtendedIngredientByResultID(resultId)
    }

    override suspend fun getAllExtendedIngredient(): Flow<ExtendedIngredient> {
        return eiDao.getAllExtendedIngredient()
    }

    override suspend fun insertResult(result: List<ExtendedIngredient>) {
        eiDao.insertResult(result)
    }
}