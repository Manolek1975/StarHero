package com.delek.starhero.ui.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.database.entity.HeroItemEntity
import com.delek.starhero.data.repository.HeroItemRepository
import com.delek.starhero.domain.model.HeroItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val heroItemRepo : HeroItemRepository
) : ViewModel() {

    val item = MutableLiveData<HeroItem>()

    fun insertHeroItem(heroItem: HeroItemEntity){
        viewModelScope.launch {
            heroItemRepo.insert(heroItem)
        }

    }
}