package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.DwellingDao
import com.delek.starhero.data.database.entity.DwellingEntity
import com.delek.starhero.domain.model.Dwelling
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class DwellingRepository @Inject constructor(private val dao: DwellingDao) {

    suspend fun insertDwellings(dwellings: List<DwellingEntity>) = dao.insert(dwellings)

    suspend fun getAllDwellings(): List<Dwelling> {
        val response: List<DwellingEntity> = dao.getAllDwellings()
        return response.map { it.toDomain()}
    }

    suspend fun getDwellingById(id: Int): Dwelling {
        val response: DwellingEntity = dao.getDwellingById(id)
        return response.toDomain()
    }

    suspend fun getDwellingByPlanet(id: Int): Dwelling? {
        val response: DwellingEntity? = dao.getDwellingByPlanet(id)
        return response?.toDomain()

    }


}