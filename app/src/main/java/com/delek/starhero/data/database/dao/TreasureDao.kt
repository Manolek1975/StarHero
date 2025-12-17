package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.TreasureEntity

@Dao
interface TreasureDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTreasures(advices: List<TreasureEntity>)

    @Query("SELECT * FROM treasures")
    suspend fun getAllTTreasures(): List<TreasureEntity>

    @Query("SELECT * FROM treasures WHERE id == :id")
    suspend fun getTreasureById(id: Int): TreasureEntity

}