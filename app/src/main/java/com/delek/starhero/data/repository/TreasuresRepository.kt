package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.TreasureDao
import com.delek.starhero.data.database.entity.TreasureEntity
import com.delek.starhero.domain.model.Treasure
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class TreasuresRepository @Inject constructor(private val treasureDao: TreasureDao) {

    suspend fun insertAll(weapons: List<TreasureEntity>) = treasureDao.insertTreasures(weapons)

    suspend fun getAllTreasures(): List<Treasure> {
        val response: List<TreasureEntity> = treasureDao.getAllTTreasures()
        return response.map { it.toDomain() }
    }

    suspend fun getTreasureById(id: Int): Treasure {
        val response: TreasureEntity = treasureDao.getTreasureById(id)
        return response.toDomain()
    }
}