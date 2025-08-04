package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "relations")
data class RelationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val heroId: Int,
    val groupId: Int,
    val relation: Int
)