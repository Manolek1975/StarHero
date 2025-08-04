package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.GroupEntity

@Dao
interface GroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(nativeGroups: List<GroupEntity>)

    @Query("SELECT * FROM groups")
    suspend fun getAll(): List<GroupEntity>

    @Query("SELECT * FROM groups WHERE id = :id")
    suspend fun getById(id: Int): GroupEntity

}