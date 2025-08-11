package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.StarDao
import com.delek.starhero.data.database.entity.StarEntity
import com.delek.starhero.domain.model.Star
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class StarRepository @Inject constructor(private val starDao: StarDao) {

    suspend fun insertStars(star: List<StarEntity>) = starDao.insertAll(star)

    suspend fun getAllStars(): List<Star> {
        val response: List<StarEntity> = starDao.getAll()
        return response.map { it.toDomain() }
    }

    fun getStars(): List<Star> {
        val response: List<StarEntity> = starDao.getStars()
        return response.map { it.toDomain() }
    }

    suspend fun getStarById(id: Int): Star {
        val response: StarEntity = starDao.getStarById(id)
        return response.toDomain()
    }

    suspend fun updatePosStar(x: Int, y: Int, id: Int) {
        starDao.updatePosStar(x,y,id)
    }
}