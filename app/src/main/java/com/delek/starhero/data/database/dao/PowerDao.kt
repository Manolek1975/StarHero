package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.PowerEntity

@Dao
interface PowerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(powerTypes: List<PowerEntity>)

    @Query("SELECT * FROM powers")
    suspend fun getAllPower(): List<PowerEntity>

    @Query("SELECT * FROM powers WHERE id = :id")
    suspend fun getPowerById(id: Int): PowerEntity


}