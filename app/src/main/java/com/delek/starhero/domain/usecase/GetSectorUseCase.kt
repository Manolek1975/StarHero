package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.SectorProvider
import com.delek.starhero.data.repository.SectorRepository
import com.delek.starhero.domain.model.Sector
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSectorUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val sectorRepository: SectorRepository
) {

    suspend operator fun invoke(): List<Sector> {
        val stars = sectorRepository.getAllStars()
        return if (stars.isEmpty()) {
            sectorRepository.insertStars(SectorProvider.loadStars(context))
            stars
        } else {
            sectorRepository.getAllStars()
        }
    }

}