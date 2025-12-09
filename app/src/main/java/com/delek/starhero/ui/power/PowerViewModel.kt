package com.delek.starhero.ui.power

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.data.repository.PowerRepository
import com.delek.starhero.data.repository.StarRepository
import com.delek.starhero.domain.model.Dwelling
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Power
import com.delek.starhero.domain.model.Star
import com.delek.starhero.domain.model.StartPower
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PowerViewModel @Inject constructor(
    private val repoHero: HeroRepository,
    private val repoStar: StarRepository,
    private val repoPlanet: PlanetRepository,
    private val repoDwelling: DwellingRepository,
    private val repoPower: PowerRepository,
): ViewModel() {

    val hero = MutableLiveData<Hero>()
    val stars = MutableLiveData<List<Star>>()
    val planet = MutableLiveData<Planet>()
    val dwelling = MutableLiveData<List<Dwelling>>()
    val power = MutableLiveData<List<Power>>()
    val powerType = MutableLiveData<List<StartPower>>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(repoHero.getHeroById(id))
        }
    }

    fun getPowerByType(id: Int) {
        viewModelScope.launch {
            power.value = repoPower.getPowerByType(id)
        }
    }

    fun getStartPowerTypes(id: Int) {
        viewModelScope.launch {
            powerType.value = repoHero.getStartPowerByRole(id)
        }
    }

    fun updateStarAdvice(id: Int, advice: Int) {
        viewModelScope.launch {
            repoStar.updateStarAdvice(id, advice)
        }
    }

    fun updateDwellingPlanet(id: Int, planet: Int) {
        viewModelScope.launch {
            repoDwelling.updateDwellingPlanet(id, planet)
        }
    }

    fun getPlanetByDwelling(id: Int) {
        viewModelScope.launch {
            planet.value = repoPlanet.getPlanetById(repoDwelling.getPlanetByDwelling(id))
        }
    }

}