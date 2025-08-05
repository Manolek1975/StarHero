package com.delek.starhero.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.GroupRepository
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.ShipRepository
import com.delek.starhero.data.repository.SkillRepository
import com.delek.starhero.data.repository.WeaponRepository
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Ship
import com.delek.starhero.domain.model.Skill
import com.delek.starhero.domain.model.Weapon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: HeroRepository,
    private val weaponRepository: WeaponRepository,
    private val shipRepository: ShipRepository,
    private val skillRepository: SkillRepository,
    private val repoGroup: GroupRepository,
) : ViewModel() {

    val hero = MutableLiveData<Hero>()
    val weapon = MutableLiveData<Weapon>()
    val ship = MutableLiveData<Ship>()
    val skill = MutableLiveData<Skill>()
    val allyNatives = MutableLiveData<List<Group>>()
    val friendlyNatives = MutableLiveData<List<Group>>()
    val unfriendlyNatives = MutableLiveData<List<Group>>()
    val enemyNatives = MutableLiveData<List<Group>>()

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

    fun getShipById(id: Int) {
        viewModelScope.launch {
            ship.postValue(shipRepository.getShipById(id))
        }
    }

    fun getSkillById(id: Int) {
        viewModelScope.launch {
            skill.postValue(skillRepository.getSkillById(id))
        }
    }

    fun getAllyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoGroup.getAllyNatives(id)
            allyNatives.value = rolNatives
        }
    }

    fun getFriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoGroup.getFriendlyNatives(id)
            friendlyNatives.value = rolNatives
        }
    }

    fun getUnfriendlyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoGroup.getUnfriendNatives(id)
            unfriendlyNatives.value = rolNatives
        }
    }

    fun getEnemyNatives(id: Int) {
        viewModelScope.launch {
            val rolNatives = repoGroup.getEnemyNatives(id)
            enemyNatives.value = rolNatives
        }
    }


}