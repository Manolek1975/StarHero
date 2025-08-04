package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.RelationEntity

@Dao
interface RelationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(nativeRelations: List<RelationEntity>)

    @Query("SELECT * FROM relations")
    suspend fun getAll(): List<RelationEntity>

    @Query("SELECT * FROM relations WHERE heroId = :id")
    suspend fun getByHeroId(id: Int): RelationEntity

}