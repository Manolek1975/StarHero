package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.HeroItemEntity

data class HeroItem(
    val id: Int,
    val itemId: Int,
    val box: Int
)

fun HeroItemEntity.toDomain() = HeroItem(id, itemId, box)