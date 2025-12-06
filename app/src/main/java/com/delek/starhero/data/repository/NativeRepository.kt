package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.NativeDao
import com.delek.starhero.data.database.entity.NativeEntity
import com.delek.starhero.domain.model.Native
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class NativeRepository @Inject constructor(private val nativeDao: NativeDao) {

    suspend fun insertNatives(natives: List<NativeEntity>) {
        nativeDao.insertNatives(natives)
    }

    suspend fun getNatives(): List<Native> {
        val response: List<NativeEntity> = nativeDao.getNatives()
        return response.map { it.toDomain() }
    }

    suspend fun getNativeById(id: Int): Native {
        val response: NativeEntity = nativeDao.getNativeById(id)
        return response.toDomain()
    }

    suspend fun getNativeByGroup(groupId: Int): List<Native> {
        val response: List<NativeEntity> = nativeDao.getNativesByGroup(groupId)
        return response.map { it.toDomain() }
    }

}