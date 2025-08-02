package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.HeroEntity

data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val icon: String,
    val size: String,
    val skill: Int,
    val weapon: Int,
    val strength: Int,
    val defense: Int,
    val health: Int,
    val speed: Int,
    val power: Int,
    val relations: Int

)

fun HeroEntity.toDomain() =
    Hero(id, name, image, icon, size, skill, weapon, strength, defense, health, speed, power, relations)