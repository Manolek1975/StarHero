package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weapons")
data class WeaponEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: String,
    val image: String,
    val weight: Int,
    val minDamage: Int,
    val maxDamage: Int,
    val price: Int
)
