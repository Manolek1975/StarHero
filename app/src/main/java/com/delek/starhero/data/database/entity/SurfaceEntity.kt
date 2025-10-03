package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surfaces")
data class SurfaceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val planetID: Int,
    val name: String,
    val image: String,
    val description: String
)
