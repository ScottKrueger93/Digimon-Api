package com.syntax_institut.android_ta_apiwdh.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.syntax_institut.android_ta_apiwdh.data.model.Digimon
import com.syntax_institut.android_ta_apiwdh.data.remote.DigimonApi

class Repository(private val apiService: DigimonApi) {

    private var _digimons = MutableLiveData<List<Digimon>>()
    val digimons: LiveData<List<Digimon>>
        get() = _digimons
    suspend fun getDigimons(id: Int) {
        val result = apiService.retrofitService.getDigimonExample(id)
        _digimons.postValue(result.content)
    }

    private var _digimon = MutableLiveData<List<Digimon>>()
    val digimon: LiveData<List<Digimon>>
        get() = _digimon

    suspend fun getDigimon(){
        val result = apiService.retrofitService.getDigimon()
        _digimon.postValue(result.content)
    }

}