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

    @Query("SELECT * FROM groups WHERE dwelling = :dwelling")
    suspend fun getGroupByDwelling(dwelling: Int): List<GroupEntity>

    @Query("SELECT groups.* FROM groups INNER JOIN relations " +
            "ON groups.id = relations.groupId " +
            "WHERE relations.heroId = :id " +
            "AND relations.relation = '1'")
    suspend fun getAllyNatives(id: Int): List<GroupEntity>

    @Query("SELECT groups.* FROM groups INNER JOIN relations " +
            "ON groups.id = relations.groupId " +
            "WHERE relations.heroId = :id " +
            "AND relations.relation = '2'")
    suspend fun getFriendlyNatives(id: Int): List<GroupEntity>

    @Query("SELECT groups.* FROM groups INNER JOIN relations " +
            "ON groups.id = relations.groupId " +
            "WHERE relations.heroId = :id " +
            "AND relations.relation = '4'")
    suspend fun getUnfriendlyNatives(id: Int): List<GroupEntity>

    @Query("SELECT groups.* FROM groups INNER JOIN relations " +
            "ON groups.id = relations.groupId " +
            "WHERE relations.heroId = :id " +
            "AND relations.relation = '5'")
    suspend fun getEnemyNatives(id: Int): List<GroupEntity>

    @Query("UPDATE groups SET dwelling = :dwelling WHERE id = :id")
    suspend fun updateGroupStart(id: Int, dwelling: Int)

    @Query("DELETE FROM groups")
    suspend fun deleteGroups()
}
