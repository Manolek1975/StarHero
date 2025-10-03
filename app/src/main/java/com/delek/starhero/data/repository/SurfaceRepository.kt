package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.SurfaceDao
import com.delek.starhero.data.database.entity.SurfaceEntity
import com.delek.starhero.domain.model.Surface
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class SurfaceRepository @Inject constructor(private val surfaceDao: SurfaceDao) {

    suspend fun insertAll(surface: List<SurfaceEntity>) = surfaceDao.insertAll(surface)

    suspend fun getAll(): List<Surface> {
        val response: List<SurfaceEntity> = surfaceDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getSurfaceById(id: Int): Surface {
        val response: SurfaceEntity = surfaceDao.getSurfaceById(id)
        return response.toDomain()
    }

}