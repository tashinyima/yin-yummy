package com.example.yinyummy.viewmodel

import com.example.yinyummy.model.Result
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.example.yinyummy.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(private val resultRepository: ResultRepository): ViewModel() {

    lateinit var resultLiveData: LiveData<List<Result>>

    fun loadResult(){
        resultLiveData = liveData {
            emitSource(resultRepository.getAllResult().asLiveData())
        }
    }

}