package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes")
data class HeroEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val image: String,
    val icon: String,
    val size: String,
    val skill: Int,
    val strength: Int,
    val defense: Int,
    val power: Int,
    val speed: Int,
    val relations: Int
)