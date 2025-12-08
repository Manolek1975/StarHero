package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.DwellingEntity

data class Dwelling(
    val id: Int,
    val name: String,
    val image: String,
    val planet: Int
)

fun DwellingEntity.toDomain() = Dwelling(id, name, image, planet)