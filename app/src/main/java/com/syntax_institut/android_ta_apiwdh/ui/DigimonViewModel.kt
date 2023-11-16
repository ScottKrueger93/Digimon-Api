package com.syntax_institut.android_ta_apiwdh.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syntax_institut.android_ta_apiwdh.data.Repository
import com.syntax_institut.android_ta_apiwdh.data.remote.DigimonApi
import kotlinx.coroutines.launch

class DigimonViewModel: ViewModel() {

    private val repository = Repository(DigimonApi)
    val digimon = repository.digimon
    var counter = 0
    init {
        loadDigimon()
    }

    fun loadDigimon(){
        viewModelScope.launch {
            repository.getDigimon()
        }
    }

    fun loadDigimonsPage() {
        counter++
        viewModelScope.launch {
            repository.getnextPage(counter)
        }
    }

}