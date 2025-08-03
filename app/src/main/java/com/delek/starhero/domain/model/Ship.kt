package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.ShipEntity

data class Ship(
    val id: Int,
    val name: String,
    val image: String,
    val hulk: String,
    val weapon: Int,
    val shield: Int,
    val speed: Int,
)

fun ShipEntity.toDomain() = Ship(id, name, image, hulk, weapon, shield, speed)