package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.RelationEntity

data class Relation(
    val id: Int,
    val heroId: Int,
    val groupId: Int,
    val relation: Int
)

fun RelationEntity.toDomain() = Relation(id, heroId, groupId, relation)