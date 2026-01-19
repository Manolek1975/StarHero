package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.MonsterDao
import com.delek.starhero.data.database.entity.MonsterEntity
import com.delek.starhero.domain.model.Monster
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class MonsterRepository @Inject constructor(private val monsterDao: MonsterDao) {

    suspend fun insertMonsters(monsters: List<MonsterEntity>) {
        monsterDao.insertAll(monsters)
    }

    suspend fun getAllMonsters(): List<Monster> {
        val response: List<MonsterEntity> = monsterDao.getAllMonsters()
        return response.map { it.toDomain() }
    }

    suspend fun getMonsterById(id: Int): Monster {
        val response: MonsterEntity = monsterDao.getMonsterById(id)
        return response.toDomain()

    }

}