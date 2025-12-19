package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "treasures")
data class TreasureEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val damage: Int,
    val str: Int,
    val def: Int,
    val hp: Int,
    val spd: Int,
    val pow: Int,
    val skill: Int,
    val price: Int

)
