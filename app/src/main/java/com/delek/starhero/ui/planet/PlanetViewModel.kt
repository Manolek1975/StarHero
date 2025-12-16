package com.delek.starhero.ui.planet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.data.repository.ShipRepository
import com.delek.starhero.domain.model.Dwelling
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Ship
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(
    private val planetRepo: PlanetRepository,
    private val dwellingRepo: DwellingRepository,
    private val shipRepo: ShipRepository
): ViewModel() {

    val planet = MutableLiveData<Planet>()
    val dwelling = MutableLiveData<Dwelling>()
    val ship = MutableLiveData<Ship>()

    fun getPlanetById(id: Int) {
        viewModelScope.launch {
            planet.postValue(planetRepo.getPlanetById(id))
        }
    }

    fun getDwellingByPlanet(id: Int) {
        viewModelScope.launch {
            dwelling.postValue(dwellingRepo.getDwellingByPlanet(id))
        }
    }

    fun getShipById(id: Int) {
        viewModelScope.launch {
            ship.postValue(shipRepo.getShipById(id))
        }

    }

}