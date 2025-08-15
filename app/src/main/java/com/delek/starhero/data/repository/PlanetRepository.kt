package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.PlanetDao
import com.delek.starhero.data.database.entity.PlanetEntity
import com.delek.starhero.domain.model.Planet
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class PlanetRepository @Inject constructor(private val planetDao: PlanetDao) {

    suspend fun insertAll(planet: List<PlanetEntity>) = planetDao.insertAll(planet)

    suspend fun getAll(): List<Planet> {
        val response: List<PlanetEntity> = planetDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getPlanetById(id: Int): Planet {
        val response: PlanetEntity = planetDao.getPlanetById(id)
        return response.toDomain()
    }

}