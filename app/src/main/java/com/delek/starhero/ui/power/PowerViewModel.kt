package com.delek.starhero.ui.power

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.PowerRepository
import com.delek.starhero.data.repository.StartPowerRepository
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Power
import com.delek.starhero.domain.model.StartPower
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PowerViewModel @Inject constructor(
    private val repoHero: HeroRepository,
    private val repoPower: PowerRepository,
    private val repoStartPower: StartPowerRepository
): ViewModel() {

    val hero = MutableLiveData<Hero>()
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


}