package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.StartPowerDao
import com.delek.starhero.data.database.entity.StartPowerEntity
import com.delek.starhero.domain.model.StartPower
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class StartPowerRepository @Inject constructor(private val startPowerDao: StartPowerDao) {

    suspend fun insertStartPower(startPower: List<StartPowerEntity>) = startPowerDao.insertStartPower(startPower)

    suspend fun getAllStartPowers(): List<StartPower> {
        val response: List<StartPowerEntity> = startPowerDao.getAllStartPowers()
        return response.map { it.toDomain() }
    }

}