package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.PlanetEntity

class PlanetProvider {

    companion object{
        fun loadPlanets(context: Context): List<PlanetEntity> {
            val planets = mutableListOf<PlanetEntity>()
            val names = context.resources.getStringArray(R.array.name_stars)
            val types = context.resources.getStringArray(R.array.type_stars)

            for (i in names.indices) {
                if(types[i] == "S"){
                    for (s in 1..4) {
                        planets.add(PlanetEntity(i+s, names[i], "", types[i], i, i, 0, 0))
                    }
                }
                if(types[i] == "A"){
                    for (a in 5..7) {
                        planets.add(PlanetEntity(i+a, names[i], "", types[i], i, i, 0, 0))
                    }
                }
                if(types[i] == "R"){
                    for (r in 8..13) {
                        planets.add(PlanetEntity(i+r, names[i], "", types[i], i, i, 0, 0))
                    }
                }
                if(types[i] == "B"){
                    for (b in 14..19) {
                        planets.add(PlanetEntity(i+b, names[i], "", types[i], i, i, 0, 0))
                    }
                }
            }
            return planets
        }
    }
}