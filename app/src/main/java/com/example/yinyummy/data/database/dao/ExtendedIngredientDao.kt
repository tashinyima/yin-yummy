package com.example.yinyummy.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yinyummy.model.ExtendedIngredient
import kotlinx.coroutines.flow.Flow

@Dao
interface ExtendedIngredientDao {


    @Query("SELECT *  FROM extendedIngredient ")
    fun getAllExtendedIngredient(): Flow<ExtendedIngredient>

    @Query("SELECT * FROM extendedIngredient WHERE resultId=:resultId ORDER BY id ASC")
    fun getExtendedIngredientByResultID(resultId: Int):Flow<List<ExtendedIngredient>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(ei: List<ExtendedIngredient>)

    @Query("DELETE FROM extendedIngredient")
    fun deleteAll()
}