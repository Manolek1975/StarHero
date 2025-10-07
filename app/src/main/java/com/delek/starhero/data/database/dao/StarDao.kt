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

    @Query("SELECT * FROM stars ORDER BY RANDOM() LIMIT 20")
    suspend fun getAllStars(): List<StarEntity>

    @Query("SELECT * FROM stars")
    fun getStars(): List<StarEntity>

    @Query("SELECT * FROM stars WHERE id = :id")
    suspend fun getStarById(id: Int): StarEntity

    @Query("SELECT * FROM stars WHERE type = :type ORDER BY RANDOM() LIMIT 20")
    suspend fun getStarsByType(type: String): List<StarEntity>

    @Query("UPDATE stars SET x = :x, y = :y WHERE id = :id")
    suspend fun updatePosStar(x: Int, y: Int, id: Int)

    @Query("UPDATE stars SET advice = :advice WHERE id = :id")
    suspend fun updateStarAdvice(id: Int, advice: Int)

}