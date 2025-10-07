package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.AdviceChitDao
import com.delek.starhero.data.database.entity.AdviceChitEntity
import com.delek.starhero.domain.model.AdviceChit
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class AdviceChitRepository @Inject constructor(private val adviceChitDao: AdviceChitDao) {

    suspend fun insertAdviceChits(advices: List<AdviceChitEntity>) {
        adviceChitDao.insertAdviceChit(advices)
    }

    suspend fun getAllAdviceChits(): List<AdviceChit> {
        val response: List<AdviceChitEntity> = adviceChitDao.getAllAdviceChits()
        return response.map { it.toDomain() }
    }

    suspend fun getAdviceChitsByStart(): List<AdviceChit> {
        val response: List<AdviceChitEntity> = adviceChitDao.getAdviceChitsByStart()
        return response.map { it.toDomain() }
    }

    suspend fun getAdviceChitById(id: Int): AdviceChit {
        val response: AdviceChitEntity = adviceChitDao.getAdviceChitById(id)
        return response.toDomain()
    }

}