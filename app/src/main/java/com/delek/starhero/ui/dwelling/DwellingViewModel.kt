package com.delek.starhero.ui.dwelling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.data.repository.GroupRepository
import com.delek.starhero.data.repository.NativeRepository
import com.delek.starhero.domain.model.Dwelling
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Native
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DwellingViewModel @Inject constructor(
    private val dwellingRepo: DwellingRepository,
    private val groupRepo: GroupRepository,
    private val nativeRepo: NativeRepository
) : ViewModel() {

    val dwelling = MutableLiveData<Dwelling>()
    val natives = MutableLiveData<List<Native>>()
    val group = MutableLiveData<List<Group>>()

    fun getDwellingById(id: Int) {
        viewModelScope.launch {
            dwelling.value = dwellingRepo.getDwellingById(id)
        }
    }

    fun getGroupByDwelling(dwelling: Int) {
        viewModelScope.launch {
            group.value = groupRepo.getGroupByDwelling(dwelling)
        }
    }

    fun getNatives() {
        viewModelScope.launch {
            natives.value = nativeRepo.getNatives()
        }
    }

    fun getNativesByGroup(groupId: Int) {
        viewModelScope.launch {
            natives.value = nativeRepo.getNativeByGroup(groupId)
        }
    }

    fun getDwellingByPlanet(id: Int) {
        viewModelScope.launch {
            dwelling.postValue(dwellingRepo.getDwellingByPlanet(id))
        }
    }

}