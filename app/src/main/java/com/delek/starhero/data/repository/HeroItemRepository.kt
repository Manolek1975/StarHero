package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.HeroItemDao
import com.delek.starhero.data.database.entity.HeroItemEntity
import com.delek.starhero.domain.model.HeroItem
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class HeroItemRepository @Inject constructor(private val heroItemDao: HeroItemDao) {

    suspend fun insert(heroItem: HeroItemEntity) = heroItemDao.insert(heroItem)

    suspend fun getAll(): List<HeroItem> {
        val response: List<HeroItemEntity> = heroItemDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun deleteHeroItems() {
        heroItemDao.deleteHeroItems()
    }
}