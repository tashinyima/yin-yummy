package com.example.yinyummy.appInit

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.yinyummy.global.Constants.Companion.API_KEY
import com.example.yinyummy.repository.EntireRepository
import dagger.hilt.android.internal.Contexts
import javax.inject.Inject


class AppInitializerImpl @Inject constructor(
    private val context: Context,
    private val entireRepository: EntireRepository
) : AppInitializer {
    @RequiresApi(Build.VERSION_CODES.M) // api
    override suspend fun initializeApp() {

        if (hasInternetConnection()) {
            val isSuccess = entireRepository.getAllRecipe(applyGetAllQueries())
            if (!isSuccess) {
                Toast.makeText(context, "Error occurred", Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(context,"success",Toast.LENGTH_SHORT).show()
            }

        }else {
            Toast.makeText(context,"failed to connect internet", Toast.LENGTH_LONG).show()
        }

    }

    private fun applyGetAllQueries(): HashMap<String, String> {
        var queries: HashMap<String, String> = HashMap()
        queries["number"] = "50"
        queries["apiKey"] = API_KEY
        queries["addRecipeInformation"] = "true"
        queries["fillIngredients"] = "true"
        Log.i("Qq", queries.toString())
        return queries



    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun hasInternetConnection(): Boolean {

        val connectivityManager = Contexts.getApplication(context)
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false

        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }


    }
}