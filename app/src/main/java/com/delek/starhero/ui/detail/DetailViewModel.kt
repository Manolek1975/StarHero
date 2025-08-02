package com.delek.starhero.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.WeaponRepository
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: HeroRepository,
    private val weaponRepository: WeaponRepository
) : ViewModel() {

    val hero = MutableLiveData<Hero>()
    val weapon = MutableLiveData<Weapon>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(repository.getHeroById(id))
        }
    }

    fun getWeaponById(id: Int) {
        viewModelScope.launch {
            weapon.postValue(weaponRepository.getWeaponById(id))
        }
    }


}