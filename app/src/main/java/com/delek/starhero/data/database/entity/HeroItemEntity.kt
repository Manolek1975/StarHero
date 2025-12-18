package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hero_items")
data class HeroItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val itemId: Int,
    val box: Int,
    val equip: Boolean

)