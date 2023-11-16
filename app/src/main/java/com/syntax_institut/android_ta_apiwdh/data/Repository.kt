package com.syntax_institut.android_ta_apiwdh.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_ta_apiwdh.data.model.Digimon
import com.syntax_institut.android_ta_apiwdh.data.remote.DigimonApi

class Repository(private val apiService: DigimonApi) {

    private var _digimon = MutableLiveData<List<Digimon>>()
    val digimon: LiveData<List<Digimon>>
        get() = _digimon

    suspend fun getDigimon(){
        val result = apiService.retrofitService.getDigimon()
        _digimon.postValue(result.content)
    }

    suspend fun getnextPage(page: Int){
        val result = apiService.retrofitService.getDigimonsPage(page)
        _digimon.postValue(result.content)
    }

}