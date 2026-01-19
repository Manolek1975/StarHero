package com.delek.starhero.ui.surface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.MonsterRepository
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Monster
import com.delek.starhero.domain.model.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurfaceViewModel @Inject constructor(
    private val planetRepository: PlanetRepository,
    private val heroRepository: HeroRepository,
    private val monsterRepository: MonsterRepository
): ViewModel() {

    val planet = MutableLiveData<Planet>()
    val hero = MutableLiveData<Hero>()
    val monster = MutableLiveData<Monster>()

    fun getPlanetById(id: Int) {
        viewModelScope.launch {
            planet.postValue(planetRepository.getPlanetById(id))
        }
    }

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(heroRepository.getHeroById(id))
        }
    }

    fun getMonsterById(id: Int) {
        viewModelScope.launch {
            monster.postValue(monsterRepository.getMonsterById(id))
        }

    }


}