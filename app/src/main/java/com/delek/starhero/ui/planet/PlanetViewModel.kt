package com.delek.starhero.ui.planet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.domain.model.Planet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val planetRepository: PlanetRepository
): ViewModel() {

    val planet = MutableLiveData<Planet>()

    fun getPlanetById(id: Int) {
        viewModelScope.launch {
            planet.postValue(planetRepository.getPlanetById(id))
        }
    }

}