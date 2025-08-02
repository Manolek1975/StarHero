package com.delek.starhero.data.repository

import com.delek.starhero.data.database.dao.WeaponDao
import com.delek.starhero.data.database.entity.WeaponEntity
import com.delek.starhero.domain.model.Weapon
import com.delek.starhero.domain.model.toDomain
import javax.inject.Inject

class WeaponRepository @Inject constructor(private val weaponDao: WeaponDao) {

    suspend fun insertAll(weapons: List<WeaponEntity>) {
        weaponDao.insertAll(weapons)
    }

    suspend fun getAllWeapons(): List<Weapon> {
        val response: List<WeaponEntity> = weaponDao.getAllWeapons()
        return response.map { it.toDomain() }
    }

    suspend fun getWeaponById(id: Int): Weapon {
        val response: WeaponEntity = weaponDao.getWeaponById(id)
        return response.toDomain()
    }

}