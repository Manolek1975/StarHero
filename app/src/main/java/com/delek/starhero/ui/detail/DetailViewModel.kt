package com.delek.starhero.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.data.repository.GroupRepository
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.data.repository.ShipRepository
import com.delek.starhero.data.repository.SkillRepository
import com.delek.starhero.data.repository.WeaponRepository
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Ship
import com.delek.starhero.domain.model.Skill
import com.delek.starhero.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val heroRepo: HeroRepository,
    private val weaponRepo: WeaponRepository,
    private val shipRepo: ShipRepository,
    private val skillRepo: SkillRepository,
    private val groupRepo: GroupRepository,
    private val planetRepo: PlanetRepository,
    private val dwellingRepo: DwellingRepository
) : ViewModel() {

    val hero = MutableLiveData<Hero>()
    val weapon = MutableLiveData<Weapon>()
    val ship = MutableLiveData<Ship>()
    val skill = MutableLiveData<Skill>()
    val allyNatives = MutableLiveData<List<Group>>()
    val friendlyNatives = MutableLiveData<List<Group>>()
    val unfriendlyNatives = MutableLiveData<List<Group>>()
    val enemyNatives = MutableLiveData<List<Group>>()
    val planet = MutableLiveData<Planet>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(heroRepo.getHeroById(id))
        }
    }

    fun getWeaponById(id: Int) {
        viewModelScope.launch {
            weapon.postValue(weaponRepo.getWeaponById(id))
        }
    }

    fun getShipById(id: Int) {
        viewModelScope.launch {
            ship.postValue(shipRepo.getShipById(id))
        }
    }

    fun getSkillById(id: Int) {
        viewModelScope.launch {
            skill.postValue(skillRepo.getSkillById(id))
        }
    }

    fun getAllyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = groupRepo.getAllyNatives(id)
            allyNatives.value = rolNatives
        }
    }

    fun getFriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = groupRepo.getFriendlyNatives(id)
            friendlyNatives.value = rolNatives
        }
    }

    fun getUnfriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = groupRepo.getUnfriendNatives(id)
            unfriendlyNatives.value = rolNatives
        }
    }

    fun getEnemyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = groupRepo.getEnemyNatives(id)
            enemyNatives.value = rolNatives
        }
    }

    fun getPlanetByDwelling(id: Int) {
        viewModelScope.launch {
            planet.value = planetRepo.getPlanetById(dwellingRepo.getPlanetByDwelling(id))
        }
    }

    fun updateDwellingPlanet(id: Int, planet: Int) {
        viewModelScope.launch {
            dwellingRepo.updateDwellingPlanet(id, planet)
        }
    }


}