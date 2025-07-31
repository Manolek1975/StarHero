package com.delek.starhero.ui.select

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {

    val heroes = MutableLiveData<List<Hero>>()

    init {
        viewModelScope.launch {
            heroes.postValue(repository.getAllHeroes())
        }
    }

}