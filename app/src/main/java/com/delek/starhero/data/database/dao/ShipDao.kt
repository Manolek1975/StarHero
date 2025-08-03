package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.ShipEntity

@Dao
interface ShipDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ships: List<ShipEntity>)

    @Query("SELECT * FROM ships")
    suspend fun getAll(): List<ShipEntity>

    @Query("SELECT * FROM ships WHERE id = :id")
    suspend fun getShipById(id: Int): ShipEntity

}