package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.DwellingEntity

@Dao
interface DwellingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dwelling: List<DwellingEntity>)

    @Query("SELECT * FROM dwellings")
    suspend fun getAllDwellings(): List<DwellingEntity>

    @Query("SELECT * FROM dwellings WHERE id = :id")
    suspend fun getDwellingById(id: Int): DwellingEntity

    @Query("SELECT * FROM dwellings WHERE planet = :id")
    suspend fun getDwellingByPlanet(id: Int): DwellingEntity?

    @Query("UPDATE dwellings SET planet = :planet WHERE id = :id")
    suspend fun updateDwellingPlanet(id: Int, planet: Int)

    @Query("SELECT planet FROM dwellings WHERE id = :id")
    suspend fun getPlanetByDwelling(id: Int): Int

    @Query("DELETE FROM dwellings")
    suspend fun deleteDwellings()

}