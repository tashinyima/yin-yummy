package com.example.yinyummy.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yinyummy.model.Result
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {


    @Query("SELECT *  FROM result ")
    fun getAllResult(): Flow<List<Result>>

    @Query("SELECT * FROM result WHERE id =:id")
    fun getResultById(id: Int): Result

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResult(result: List<Result>)

    @Query("DELETE FROM result")
    fun deleteAll()


}