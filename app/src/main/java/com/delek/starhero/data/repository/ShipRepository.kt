package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.ShipDao
import com.delek.starhero.data.database.entity.ShipEntity
import com.delek.starhero.domain.model.Ship
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class ShipRepository @Inject constructor(private val shipDao: ShipDao) {

    suspend fun insertAll(ships: List<ShipEntity>) = shipDao.insertAll(ships)

    suspend fun getAll(): List<Ship> {
           val response: List<ShipEntity> = shipDao.getAll()
        return response.map { it.toDomain() }
    }

    suspend fun getShipById(id: Int): Ship {
      val response: ShipEntity = shipDao.getShipById(id)
      return response.toDomain()
    }

}