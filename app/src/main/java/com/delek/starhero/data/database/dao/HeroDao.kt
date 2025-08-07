package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.HeroEntity
import com.delek.starhero.data.database.entity.StartPowerEntity

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(heroes: List<HeroEntity>)

    @Query("SELECT * FROM heroes")
    suspend fun getAllHeroes(): List<HeroEntity>

    @Query("SELECT * FROM heroes WHERE id = :id")
    suspend fun getHeroById(id: Int): HeroEntity

    @Query("SELECT * FROM start_powers WHERE heroId = :heroId")
    suspend fun getStartPowerByRole(heroId: Int): List<StartPowerEntity>

}