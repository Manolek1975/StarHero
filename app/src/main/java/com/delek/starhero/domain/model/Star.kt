package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.StarEntity

data class Star(
    val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val x: Int,
    val y: Int
)

fun StarEntity.toDomain() = Star(id, name, image, type, x, y)