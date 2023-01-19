package com.example.yinyummy.module

import com.example.yinyummy.data.database.dao.ExtendedIngredientDao
import com.example.yinyummy.data.database.dao.MissedIngredientDao
import com.example.yinyummy.data.database.dao.ResultDao
import com.example.yinyummy.data.retrofit.FoodRecipeApi
import com.example.yinyummy.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRetroRepository(
        foodRecipeApi: FoodRecipeApi,
        resultDao: ResultDao,
        miDao: MissedIngredientDao,
        eiDao: ExtendedIngredientDao
    ): EntireRepository {
        return EntireRepositoryImpl(foodRecipeApi, resultDao, miDao, eiDao)
    }


    @Provides
    fun provideExtendedIngredientRepo(eiDao: ExtendedIngredientDao): ExtendedIngredientRepository {
        return ExtendedIngredientRepositoryImpl(eiDao)
    }


    @Provides
    fun provideMissedIngredientRepo(miDao: MissedIngredientDao): MissedIngredientRepository {

        return MissedIngredientRepositoryImpl(miDao)
    }


    @Provides
    fun provideResultRepo(resultDao: ResultDao): ResultRepository {

        return ResultRepositoryImpl(resultDao)
    }

}