package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.PlanetProvider
import com.delek.starhero.data.repository.PlanetRepository
import com.delek.starhero.domain.model.Planet
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetPlanetUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: PlanetRepository
) {

    suspend operator fun invoke(): List<Planet> {
        val planets = repository.getAll()
        return if (planets.isEmpty()) {
            repository.insertAll(PlanetProvider.loadPlanets(context))
            planets
        } else {
            repository.getAll()
        }
    }
}