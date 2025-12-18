package com.delek.starhero.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.HeroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val heroRepo : HeroRepository,
) : ViewModel() {

    val hero = MutableLiveData<Hero>()
    val item = MutableLiveData<HeroItem>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(heroRepo.getHeroById(id))
        }
    }

}