package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.SurfaceEntity

@Dao
interface SurfaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(surface: List<SurfaceEntity>)

    @Query("SELECT * FROM surfaces")
    suspend fun getAll(): List<SurfaceEntity>

    @Query("SELECT surfaces.* FROM surfaces INNER JOIN planets " +
            "ON surfaces.id = planets.type " +
            "WHERE planets.id = :id ")
    suspend fun getSurfaceById(id: Int): SurfaceEntity

}