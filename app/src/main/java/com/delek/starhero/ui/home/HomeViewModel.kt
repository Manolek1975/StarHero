package com.delek.starhero.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Ship
import com.delek.starhero.domain.model.Skill
import com.delek.starhero.domain.model.Weapon
import com.delek.starhero.domain.usecase.GetGroupUseCase
import com.delek.starhero.domain.usecase.GetHeroUseCase
import com.delek.starhero.domain.usecase.GetShipUseCase
import com.delek.starhero.domain.usecase.GetSkillUseCase
import com.delek.starhero.domain.usecase.GetWeaponUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHeroUseCase: GetHeroUseCase,
    private val getWeaponUseCase: GetWeaponUseCase,
    private val getShipUseCase: GetShipUseCase,
    private val getSkillUseCase: GetSkillUseCase,
    private val groupUseCase: GetGroupUseCase
): ViewModel() {

    private val heroList = MutableLiveData<Hero>()
    private val weaponList = MutableLiveData<Weapon>()
    private val shipList = MutableLiveData<Ship>()
    private val skillList = MutableLiveData<Skill>()
    private val groupList = MutableLiveData<Group>()

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
        viewModelScope.launch {
            val ship = getShipUseCase()
            if (ship.isNotEmpty()) {
                shipList.postValue(ship[0])
            }
        }
        viewModelScope.launch {
            val skill = getSkillUseCase()
            if (skill.isNotEmpty()) {
                skillList.postValue(skill[0])
            }
        }
        viewModelScope.launch {
            val group = groupUseCase()
            if (group.isNotEmpty()) {
                groupList.postValue(group[0])
            }
        }
   }


}