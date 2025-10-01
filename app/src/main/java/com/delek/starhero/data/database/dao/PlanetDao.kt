package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.PlanetEntity

@Dao
interface PlanetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(planets: List<PlanetEntity>)

    @Query("SELECT * FROM planets")
    suspend fun getAll(): List<PlanetEntity>

    @Query("SELECT * FROM planets WHERE id = :id")
    suspend fun getPlanetById(id: Int): PlanetEntity

    @Query("SELECT * FROM planets WHERE starId = :id")
    suspend fun getPlanetsByStarId(id: Int): List<PlanetEntity>
}