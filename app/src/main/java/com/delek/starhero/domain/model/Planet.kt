package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.PlanetEntity

data class Planet(
    val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val pos: Int,
    val starId: Int,
    val con1: Int,
    val con2: Int
)

fun PlanetEntity.toDomain() = Planet(id, name, image, type, pos, starId, con1, con2)