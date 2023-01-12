package com.example.yinyummy.repository

import android.util.Log
import com.example.yinyummy.data.database.dao.ExtendedIngredientDao
import com.example.yinyummy.data.database.dao.MissedIngredientDao
import com.example.yinyummy.data.database.dao.ResultDao
import com.example.yinyummy.data.retrofit.FoodRecipeApi
import com.example.yinyummy.model.ExtendedIngredient
import com.example.yinyummy.model.FoodRecipe
import com.example.yinyummy.model.MissedIngredient
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class EntireRepositoryImpl @Inject constructor(
    private val api: FoodRecipeApi,
    private val resultDao: ResultDao,
    private val miDao: MissedIngredientDao,
    private val eiDao: ExtendedIngredientDao
) : EntireRepository {

    override suspend fun getAllRecipe(queries: Map<String, String>): Boolean {
        val entireData = api.getAllRecipes(queries)
        if (entireData.body() == null) {
            return false

        }
        insertResult(entireData)
        return true

    }

    private suspend fun insertResult(entireData: Response<FoodRecipe>) {
        val result = entireData.body()?.results
        Log.d("Result",result.toString())

        val ei = mutableListOf<ExtendedIngredient>()
        val mi = mutableListOf<MissedIngredient>()



        resultDao.insertResult(result!!)

        result.forEach { result ->
            //it:result
            result.extendedIngredients?.let {
                it.map { it.resultId = result.id }
                ei.addAll(result.extendedIngredients)
            }
            result.missedIngredients?.let {
                it.map { it.resultId = result.id }
                mi.addAll(result.missedIngredients)
            }

        }

        insertMissedIngredient(mi)
        insertExtendedIngredient(ei)


    }

    private suspend fun insertExtendedIngredient(ei: MutableList<ExtendedIngredient>) {
        eiDao.insertResult(ei)

    }

    private suspend fun insertMissedIngredient(mi: MutableList<MissedIngredient>) {
        miDao.insertMissIngredient(mi)
    }
}