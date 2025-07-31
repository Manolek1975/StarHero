package com.delek.starhero.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.domain.model.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: HeroRepository
) : ViewModel() {

    val hero = MutableLiveData<Hero>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(repository.getHeroById(id))
        }
    }
}