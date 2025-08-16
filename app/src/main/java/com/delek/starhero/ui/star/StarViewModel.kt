package com.delek.starhero.ui.star

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delek.starhero.data.repository.StarRepository
import com.delek.starhero.domain.model.Star
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarViewModel @Inject constructor(
    private val repository: StarRepository) : ViewModel() {

    val star = MutableLiveData<Star>()

    fun getStarById(id: Int) {
        viewModelScope.launch {
            star.postValue(repository.getStarById(id))
        }
    }
}