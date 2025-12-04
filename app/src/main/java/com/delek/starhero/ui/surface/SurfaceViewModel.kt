package com.delek.starhero.ui.surface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.data.repository.SurfaceRepository
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.Surface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurfaceViewModel @Inject constructor(
    private val planetRepository: PlanetRepository,
    private val surfaceRepository: SurfaceRepository
): ViewModel() {

    val planet = MutableLiveData<Planet>()
    val surface = MutableLiveData<Surface>()

    fun getPlanetById(id: Int) {
        viewModelScope.launch {
            planet.postValue(planetRepository.getPlanetById(id))
        }
    }
    fun getSurfaceById(id: Int) {
        viewModelScope.launch {
            surface.postValue(surfaceRepository.getSurfaceById(id))
        }
    }

}