package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.StarProvider
import com.delek.starhero.data.repository.StarRepository
import com.delek.starhero.domain.model.Star
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetStarUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val starRepository: StarRepository
) {

    suspend operator fun invoke(): List<Star> {
        val stars = starRepository.getAllStars()
        return if (stars.isEmpty()) {
            starRepository.insertStars(StarProvider.loadStars(context))
            stars
        } else {
            starRepository.getAllStars()
        }
    }

}