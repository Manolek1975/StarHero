package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.DwellingProvider
import com.delek.starhero.data.repository.DwellingRepository
import com.delek.starhero.domain.model.Dwelling
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetDwellingUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: DwellingRepository) {

    suspend operator fun invoke(): List<Dwelling> {
        val dwelling = repository.getAllDwellings()
        return if (dwelling.isEmpty()) {
            repository.insertDwellings(DwellingProvider.loadDwellings(context))
            dwelling
        } else {
            repository.getAllDwellings()
        }
    }
}