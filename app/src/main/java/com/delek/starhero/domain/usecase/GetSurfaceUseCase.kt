package com.delek.starhero.domain.usecase

import android.content.Context
import com.delek.starhero.data.provider.SurfaceProvider
import com.delek.starhero.data.repository.SurfaceRepository
import com.delek.starhero.domain.model.Surface
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetSurfaceUseCase @Inject constructor(
    @ApplicationContext private val context: Context,
    private val repository: SurfaceRepository) {

    suspend operator fun invoke() : List<Surface> {
        val surface = repository.getAll()
        return if (surface.isEmpty()) {
            repository.insertAll(SurfaceProvider.loadSurfaces(context))
            surface
        } else {
            repository.getAll()
        }
    }
}