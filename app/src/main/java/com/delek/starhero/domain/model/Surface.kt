package com.delek.starhero.domain.model

import com.delek.starhero.data.database.entity.SurfaceEntity

class Surface(
    val id: Int,
    val planetID: Int,
    val name: String,
    val image: String,
    val description: String

)

fun SurfaceEntity.toDomain() = Surface(id, planetID, name, image, description)