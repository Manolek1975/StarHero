package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "start_powers")
data class StartPowerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val heroId: Int,
    val typeId: Int,
    val powerType: String,
)
