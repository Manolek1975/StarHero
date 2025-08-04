package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.GroupDao
import com.delek.starhero.data.database.entity.GroupEntity
import com.delek.starhero.domain.model.Group
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class GroupRepository @Inject constructor(private val groupDao: GroupDao) {

    suspend fun insertAll(groups: List<GroupEntity>) = groupDao.insertAll(groups)

    suspend fun getAll(): List<Group> {
        val response: List<GroupEntity> = groupDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getGroupById(id: Int): Group {
        val response: GroupEntity = groupDao.getById(id)
        return response.toDomain()
    }

}