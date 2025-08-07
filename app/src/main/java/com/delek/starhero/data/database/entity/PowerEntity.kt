package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "powers")
data class PowerEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val color: String,
    val target: String,
    val duration: String,
    val typeName: String,
    val description: String,
    val shortDescription: String
)