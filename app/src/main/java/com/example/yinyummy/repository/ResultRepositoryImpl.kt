package com.example.yinyummy.repository

import com.example.yinyummy.data.database.dao.ResultDao
import com.example.yinyummy.model.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResultRepositoryImpl @Inject constructor(private val resultDao: ResultDao) :
    ResultRepository {
    override suspend fun getAllResult(): Flow<List<Result>> {
        return resultDao.getAllResult()
    }

    override suspend fun insertResult(result: List<Result>) {
        resultDao.insertResult(result)
    }

    override suspend fun getResultById(id: Int): Result {
        return resultDao.getResultById(id)
    }
}