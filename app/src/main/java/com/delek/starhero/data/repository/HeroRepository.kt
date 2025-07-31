package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.HeroDao
import com.delek.starhero.data.database.entity.HeroEntity
import com.delek.starhero.domain.model.Hero
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class HeroRepository @Inject constructor(private val heroDao: HeroDao) {

    suspend fun insertAll(heroes: List<HeroEntity>) {
        heroDao.insertAll(heroes)
    }

    suspend fun getAllHeroes(): List<Hero> {
        val response: List<HeroEntity> = heroDao.getAllHeroes()
        return response.map { it.toDomain() }
    }

    suspend fun getHeroById(id: Int): Hero {
        val response: HeroEntity = heroDao.getHeroById(id)
        return response.toDomain()
    }
}