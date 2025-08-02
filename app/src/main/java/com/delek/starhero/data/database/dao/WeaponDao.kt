package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.WeaponEntity

@Dao
interface WeaponDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(weapons: List<WeaponEntity>)

    @Query("SELECT * FROM weapons")
    suspend fun getAllWeapons(): List<WeaponEntity>

    @Query("SELECT * FROM weapons WHERE id = :id")
    suspend fun getWeaponById(id: Int): WeaponEntity

}