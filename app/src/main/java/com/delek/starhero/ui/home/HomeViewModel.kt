package com.delek.starhero.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.usecase.GetHeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHeroUseCase: GetHeroUseCase
): ViewModel() {

    private val heroList = MutableLiveData<Hero>()

    fun onCreate() {
        viewModelScope.launch {
            val hero = getHeroUseCase()
            if (hero.isNotEmpty()) {
                heroList.postValue(hero[0])
            }
        }
   }


}