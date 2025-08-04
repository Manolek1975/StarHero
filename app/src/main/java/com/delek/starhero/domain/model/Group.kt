package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.GroupEntity

data class Group(
    val id: Int,
    val name: String,
    val start: Int,
    val ship: Int,
    val description: String,

)

fun GroupEntity.toDomain() = Group(id, name, start, ship, description)


