package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.StartPowerEntity

data class StartPower(
    val id: Int,
    val heroId: Int,
    val typeId: Int,
    val powerType: String,
)

fun StartPowerEntity.toDomain() = StartPower(id, heroId, typeId, powerType)