package com.delek.starhero.ui.surface

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.SurfaceRepository
import com.delek.starhero.domain.model.Surface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurfaceViewModel @Inject constructor(
    private val repository: SurfaceRepository
): ViewModel() {

    val surface = MutableLiveData<Surface>()

    fun getSurfaceById(id: Int) {
        viewModelScope.launch {
            surface.postValue(repository.getSurfaceById(id))
        }
    }

}