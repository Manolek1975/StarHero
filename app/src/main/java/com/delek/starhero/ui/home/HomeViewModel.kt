package com.delek.starhero.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Weapon
import com.delek.starhero.domain.usecase.GetHeroUseCase
import com.delek.starhero.domain.usecase.GetWeaponUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHeroUseCase: GetHeroUseCase,
    private val getWeaponUseCase: GetWeaponUseCase
): ViewModel() {

    private val heroList = MutableLiveData<Hero>()
    private val weaponList = MutableLiveData<Weapon>()

    fun onCreate() {
        viewModelScope.launch {
            val hero = getHeroUseCase()
            if (hero.isNotEmpty()) {
                heroList.postValue(hero[0])
            }
        }
        viewModelScope.launch {
            val weapon = getWeaponUseCase()
            if (weapon.isNotEmpty()) {
                weaponList.postValue(weapon[0])
            }
        }
   }


}