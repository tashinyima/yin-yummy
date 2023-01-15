package com.example.yinyummy.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.yinyummy.model.User


@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE uid=:id"  )
    suspend fun getUserById(id: Int): User

    @Insert(onConflict =OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)
    @Delete
    fun deleteUser(user: User)

}