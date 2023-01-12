package com.example.yinyummy.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yinyummy.model.MissedIngredient
import kotlinx.coroutines.flow.Flow

@Dao
interface MissedIngredientDao {

    @Query("SELECT * FROM missedIngredient")
    fun getAllMissIngredient(): Flow<MissedIngredient>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMissIngredient(missedIngredient: List<MissedIngredient>)

    @Query("DELETE  FROM missedIngredient")
    fun deleteAllMissIngredient()


}