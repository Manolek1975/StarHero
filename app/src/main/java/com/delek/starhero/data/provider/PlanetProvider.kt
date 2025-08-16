package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.PlanetEntity

class PlanetProvider {

    companion object{
        fun loadPlanets(context: Context): List<PlanetEntity> {
            val planets = mutableListOf<PlanetEntity>()
            val names = context.resources.getStringArray(R.array.name_planets)
            val images = context.resources.getStringArray(R.array.image_planets)

            for (i in names.indices) {
                planets.add(PlanetEntity(i+1, names[i], images[i], "", 0, 0, 0, 0))
            }
            return planets
        }
    }
}