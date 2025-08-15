package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "planets")
data class PlanetEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val pos: Int,
    val starId: Int,
    val con1: Int,
    val con2: Int
)