package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.SkillEntity

data class Skill(
    val id: Int,
    val name: String,
    val description: String,
    val image: String

)

fun SkillEntity.toDomain() = Skill(id, name, description, image)
