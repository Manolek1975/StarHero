package com.delek.starhero.ui.trade

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.GroupRepository
import com.delek.starhero.data.repository.TreasureRepository
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.Treasure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TradeViewModel @Inject constructor(
    private val treasureRepo: TreasureRepository,
    private val groupRepo: GroupRepository
) : ViewModel() {

    val treasures = MutableLiveData<List<Treasure>>()
    val group = MutableLiveData<Group>()

    fun getTreasures(){
        viewModelScope.launch {
            treasures.postValue(treasureRepo.getAllTreasures())
        }
    }

    fun getGroupById(id: Int) {
        viewModelScope.launch {
            group.postValue(groupRepo.getGroupById(id))
        }
    }


}