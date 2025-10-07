package com.delek.starhero.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.delek.starhero.data.database.entity.AdviceChitEntity

@Dao
interface AdviceChitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdviceChit(advices: List<AdviceChitEntity>)

    @Query("SELECT * FROM advice_chits")
    suspend fun getAllAdviceChits(): List<AdviceChitEntity>

    @Query("SELECT * FROM advice_chits WHERE type == 'V' AND dice == 0")
    suspend fun getAdviceChitsByStart(): List<AdviceChitEntity>

    @Query("SELECT * FROM advice_chits WHERE id == :id")
    suspend fun getAdviceChitById(id: Int): AdviceChitEntity

}