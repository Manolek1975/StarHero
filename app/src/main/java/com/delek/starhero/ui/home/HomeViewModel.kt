package com.delek.starhero.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.domain.model.Dwelling
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Power
import com.delek.starhero.domain.model.Relation
import com.delek.starhero.domain.model.Ship
import com.delek.starhero.domain.model.Skill
import com.delek.starhero.domain.model.Star
import com.delek.starhero.domain.model.StartPower
import com.delek.starhero.domain.model.Surface
import com.delek.starhero.domain.model.Weapon
import com.delek.starhero.domain.usecase.GetDwellingUseCase
import com.delek.starhero.domain.usecase.GetGroupUseCase
import com.delek.starhero.domain.usecase.GetHeroUseCase
import com.delek.starhero.domain.usecase.GetPlanetUseCase
import com.delek.starhero.domain.usecase.GetPowerUseCase
import com.delek.starhero.domain.usecase.GetRelationUseCase
import com.delek.starhero.domain.usecase.GetShipUseCase
import com.delek.starhero.domain.usecase.GetSkillUseCase
import com.delek.starhero.domain.usecase.GetStarUseCase
import com.delek.starhero.domain.usecase.GetStartPowerUseCase
import com.delek.starhero.domain.usecase.GetSurfaceUseCase
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
    private val groupUseCase: GetGroupUseCase,
    private val relationUseCase: GetRelationUseCase,
    private val getDwellingUseCase: GetDwellingUseCase,
    private val getPowerUseCase: GetPowerUseCase,
    private val startPowerUseCase: GetStartPowerUseCase,
    private val getStarUseCase: GetStarUseCase,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val getSurfaceUseCase: GetSurfaceUseCase
): ViewModel() {

    private val heroList = MutableLiveData<Hero>()
    private val weaponList = MutableLiveData<Weapon>()
    private val shipList = MutableLiveData<Ship>()
    private val skillList = MutableLiveData<Skill>()
    private val groupList = MutableLiveData<Group>()
    private val relationList = MutableLiveData<Relation>()
    private val dwellingList = MutableLiveData<Dwelling>()
    private val powerList = MutableLiveData<Power>()
    private val startPowerList = MutableLiveData<StartPower>()
    private val starList = MutableLiveData<Star>()
    private val planetList = MutableLiveData<Planet>()
    private val surfaceList = MutableLiveData<Surface>()

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
        viewModelScope.launch {
            val relation = relationUseCase()
            if (relation.isNotEmpty()) {
                relationList.postValue(relation[0])
            }
        }
        viewModelScope.launch {
            val dwelling = getDwellingUseCase()
            if (dwelling.isNotEmpty()) {
                dwellingList.postValue(dwelling[0])
            }
        }
        viewModelScope.launch {
            val power = getPowerUseCase()
            if (power.isNotEmpty()) {
                powerList.postValue(power[0])
            }
        }
        viewModelScope.launch {
            val startPower = startPowerUseCase()
            if (startPower.isNotEmpty()) {
                startPowerList.postValue(startPower[0])
            }
        }
        viewModelScope.launch {
            val star = getStarUseCase()
            if (star.isNotEmpty()) {
                starList.postValue(star[0])
            }
        }
        viewModelScope.launch {
            val planet = getPlanetUseCase()
            if (planet.isNotEmpty()) {
                planetList.postValue(planet[0])
            }
        }
        viewModelScope.launch {
            val surface = getSurfaceUseCase()
            if (surface.isNotEmpty()) {
                surfaceList.postValue(surface[0])
            }
        }
   }


}