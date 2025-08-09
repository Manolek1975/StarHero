package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.StarEntity

@Dao
interface StarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(stars: List<StarEntity>)

    @Query("SELECT * FROM stars")
    suspend fun getAll(): List<StarEntity>

    @Query("SELECT * FROM stars")
    fun getStars(): List<StarEntity>

    @Query("SELECT * FROM stars WHERE id = :id")
    suspend fun getStarById(id: Int): StarEntity

}