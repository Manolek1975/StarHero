package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.SectorDao
import com.delek.starhero.data.database.entity.SectorEntity
import com.delek.starhero.domain.model.Sector
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class SectorRepository @Inject constructor(private val sectorDao: SectorDao) {

    suspend fun insertStars(sector: List<SectorEntity>) = sectorDao.insertAll(sector)

    suspend fun getAllStars(): List<Sector> {
        val response: List<SectorEntity> = sectorDao.getAll()
        return response.map { it.toDomain() }
    }

    fun getStars(): List<Sector> {
        val response: List<SectorEntity> = sectorDao.getStars()
        return response.map { it.toDomain() }
    }

    suspend fun getStarById(id: Int): Sector {
        val response: SectorEntity = sectorDao.getStarById(id)
        return response.toDomain()
    }

    suspend fun updatePosStar(x: Int, y: Int, id: Int) {
        sectorDao.updatePosStar(x,y,id)
    }
}