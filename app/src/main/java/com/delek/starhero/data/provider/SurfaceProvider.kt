package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.SurfaceEntity

class SurfaceProvider {

    companion object{
        fun loadSurfaces(context: Context): List<SurfaceEntity> {
            val surfaces = mutableListOf<SurfaceEntity>()
            val names = context.resources.getStringArray(R.array.name_surfaces)
            val images = context.resources.getStringArray(R.array.image_surfaces)
            val description = context.resources.getStringArray(R.array.description_surfaces)

            for (i in names.indices) {
                surfaces.add(SurfaceEntity(i+1, 0, names[i], images[i], ""))
            }
            return surfaces
        }
    }
}