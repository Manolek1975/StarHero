package com.delek.starhero.ui.power

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.HeroRepository
import com.delek.starhero.data.repository.SkillRepository
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.Skill
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PowerViewModel @Inject constructor(
    private val repoHero: HeroRepository,
    private val repoSkill: SkillRepository
): ViewModel() {

    val hero = MutableLiveData<Hero>()
    val skill = MutableLiveData<Skill>()

    fun getHeroById(id: Int) {
        viewModelScope.launch {
            hero.postValue(repoHero.getHeroById(id))
        }
    }

    fun getSkillById(id: Int) {
        viewModelScope.launch {
            skill.postValue(repoSkill.getSkillById(id))
        }
    }
}