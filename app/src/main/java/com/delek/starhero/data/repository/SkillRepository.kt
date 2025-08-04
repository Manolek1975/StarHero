package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.SkillDao
import com.delek.starhero.data.database.entity.SkillEntity
import com.delek.starhero.domain.model.Skill
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class SkillRepository @Inject constructor(private val skillDao: SkillDao) {

    suspend fun insertAll(skills: List<SkillEntity>) = skillDao.insertAll(skills)

    suspend fun getAll(): List<Skill> {
        val response: List<SkillEntity> = skillDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getSkillById(id: Int): Skill {
        val response: SkillEntity = skillDao.getSkillById(id)
        return response.toDomain()
    }
}