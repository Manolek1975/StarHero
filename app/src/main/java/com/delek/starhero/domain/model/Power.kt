package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.PowerEntity

data class Power(
    val id: Int,
    val name: String,
    val type: String,
    val color: String,
    val target: String,
    val duration: String,
    val typeName: String,
    val description: String,
    val shortDescription: String
)

fun PowerEntity.toDomain() = Power(id, name, type, color, target, duration, typeName, description, shortDescription)