package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.RelationDao
import com.delek.starhero.data.database.entity.RelationEntity
import com.delek.starhero.domain.model.Relation
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class RelationRepository @Inject constructor(private val relationDao: RelationDao) {

    suspend fun insertAll(relations: List<RelationEntity>) = relationDao.insertAll(relations)

    suspend fun getAllRelations(): List<Relation> {
        val response: List<RelationEntity> = relationDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getRelationByHeroId(id: Int): Relation {
        val response: RelationEntity = relationDao.getByHeroId(id)
        return response.toDomain()
    }
}