package com.example.yinyummy.data.database.dao.di

import android.content.Context
import androidx.room.Room
import com.example.yinyummy.data.database.FoodRoomDatabase
import com.example.yinyummy.data.database.dao.ExtendedIngredientDao
import com.example.yinyummy.data.database.dao.MissedIngredientDao
import com.example.yinyummy.data.database.dao.ResultDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {


    @Singleton
    @Provides
    fun provideRoomDb(@ApplicationContext context: Context): FoodRoomDatabase {
        return Room.databaseBuilder(
            context,
            FoodRoomDatabase::class.java,
            FoodRoomDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }


    @Singleton
    @Provides
    fun provideResultDao(database: FoodRoomDatabase): ResultDao {
        return database.resultDao()
    }
    @Singleton
    @Provides
    fun provideExtendedIngredientDao(database: FoodRoomDatabase): ExtendedIngredientDao {
        return database.extendedIngredientDao()
    }

    @Singleton
    @Provides
    fun provideMissedIngredientDao(database: FoodRoomDatabase): MissedIngredientDao {
        return database.missedIngredientDao()
    }
}