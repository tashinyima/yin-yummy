package com.example.yinyummy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.yinyummy.data.database.FoodRoomDatabase.Companion.DATABASE_VERSION
import com.example.yinyummy.data.database.dao.ExtendedIngredientDao
import com.example.yinyummy.data.database.dao.MissedIngredientDao
import com.example.yinyummy.data.database.dao.ResultDao
import com.example.yinyummy.model.ExtendedIngredient
import com.example.yinyummy.model.MissedIngredient
import com.example.yinyummy.model.Result



@Database(

    entities = [
        Result::class,
        ExtendedIngredient::class,
        MissedIngredient::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class FoodRoomDatabase  :RoomDatabase(){
    abstract fun resultDao(): ResultDao
    abstract fun extendedIngredientDao(): ExtendedIngredientDao
    abstract fun missedIngredientDao(): MissedIngredientDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "yin_yummy_db"

    }

}