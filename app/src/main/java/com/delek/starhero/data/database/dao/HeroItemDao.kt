package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.delek.starhero.data.database.entity.HeroItemEntity

@Dao
interface HeroItemDao {

    @Insert
    suspend fun insert(heroItem: HeroItemEntity)

    @Query("SELECT * FROM hero_items")
    suspend fun getAll(): List<HeroItemEntity>

}