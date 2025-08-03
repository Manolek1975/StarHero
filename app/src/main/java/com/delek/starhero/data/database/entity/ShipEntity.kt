package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ships")
data class ShipEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val hulk: String,
    val weapon: Int,
    val shield: Int,
    val speed: Int,
)