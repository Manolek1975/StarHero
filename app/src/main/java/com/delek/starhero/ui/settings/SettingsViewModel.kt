package com.delek.starhero.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.data.repository.GroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val dwellingRepository: DwellingRepository,
    private val groupRepository: GroupRepository
    ): ViewModel(
){

    fun deleteDwellings(){
        viewModelScope.launch {
            dwellingRepository.deleteDwellings()
        }
    }

    fun deleteGroups(){
        viewModelScope.launch {
            groupRepository.deleteGroups()
        }

    }
}