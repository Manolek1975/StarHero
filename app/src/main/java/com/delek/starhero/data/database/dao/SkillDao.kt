package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.SkillEntity

@Dao
interface SkillDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(skills: List<SkillEntity>)

    @Query("SELECT * FROM skills")
    suspend fun getAll(): List<SkillEntity>

    @Query("SELECT * FROM skills WHERE id = :id")
    suspend fun getSkillById(id: Int): SkillEntity

}