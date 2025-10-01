package com.delek.starhero.ui.star

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.data.repository.StarRepository
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Star
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarViewModel @Inject constructor(
    private val starRepository: StarRepository,
    private val planetRepository: PlanetRepository
) : ViewModel() {

    val star = MutableLiveData<Star>()
    val planets = MutableLiveData<List<Planet>>()

    fun getStarById(id: Int) {
        viewModelScope.launch {
            star.postValue(starRepository.getStarById(id))
        }
    }

    fun getPlanetsByStarId(id: Int) {
        viewModelScope.launch {
            planets.postValue(planetRepository.getPlanetsByStarId(id))
        }
    }
}