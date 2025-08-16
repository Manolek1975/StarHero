package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.StarProvider
import com.delek.starhero.data.repository.StarRepository
import com.delek.starhero.domain.model.Star
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetStarUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: StarRepository
) {

    suspend operator fun invoke(): List<Star> {
        val stars = repository.getAllStars()
        return if (stars.isEmpty()) {
            repository.insertStars(StarProvider.loadStars(context))
            stars
        } else {
            repository.getAllStars()
        }
    }

}