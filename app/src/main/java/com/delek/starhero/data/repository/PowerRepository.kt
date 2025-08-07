package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.PowerDao
import com.delek.starhero.data.database.entity.PowerEntity
import com.delek.starhero.domain.model.Power
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class PowerRepository @Inject constructor(private val powerDao: PowerDao) {

    suspend fun insertAll(powers: List<PowerEntity>) = powerDao.insertAll(powers)


    suspend fun getAllPower(): List<Power> {
        val response: List<PowerEntity> = powerDao.getAllPower()
        return response.map { it.toDomain() }
    }

    suspend fun getPowerById(id: Int): Power {
        val response: PowerEntity = powerDao.getPowerById(id)
        return response.toDomain()
    }


}