package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.StartPowerEntity

@Dao
interface StartPowerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStartPower(startPower: List<StartPowerEntity>)

    @Query("SELECT * FROM start_powers")
    suspend fun getAllStartPowers(): List<StartPowerEntity>

    @Query("SELECT * FROM start_powers WHERE heroId = :heroId")
    suspend fun getHeroStartPowers(heroId: Int): List<StartPowerEntity>

}