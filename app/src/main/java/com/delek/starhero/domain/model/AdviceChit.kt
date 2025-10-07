package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.AdviceChitEntity

data class AdviceChit(
    val id: Int,
    val name: String,
    val type: String,
    val dice: Int,
    val dwelling: Int,
    val monster: Int,
    val native: Int
)

fun AdviceChitEntity.toDomain() = AdviceChit(id, name, type, dice, dwelling, monster, native)