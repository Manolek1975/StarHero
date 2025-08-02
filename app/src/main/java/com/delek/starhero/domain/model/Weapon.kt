package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.WeaponEntity

data class Weapon(
    val id: Int,
    val name: String,
    val type: String,
    val image: String,
    val weight: Int,
    val minDamage: Int,
    val maxDamage: Int,
    val price: Int
)

fun WeaponEntity.toDomain() = Weapon(id, name, type, image, weight, minDamage, maxDamage, price)
