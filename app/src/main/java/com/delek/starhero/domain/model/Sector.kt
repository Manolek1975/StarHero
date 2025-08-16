package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.SectorEntity

data class Sector(
    val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val x: Int,
    val y: Int
)

fun SectorEntity.toDomain() = Sector(id, name, image, type, x, y)