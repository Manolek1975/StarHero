package com.delek.starhero.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "skills")
data class SkillEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val description: String,
    val image: String
)