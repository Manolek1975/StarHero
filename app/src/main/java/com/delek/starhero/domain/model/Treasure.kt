package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.TreasureEntity

data class Treasure(
    val id: Int,
    val name: String,
    val image: String,
    val type: String,
    val damage: Int,
    val str: Int,
    val def: Int,
    val hp: Int,
    val spd: Int,
    val pow: Int,
    val skill: Int,
    val price: Int
)

fun TreasureEntity.toDomain() : Treasure = Treasure(id, name, image, type, damage, str, def, hp, spd, pow, skill, price)