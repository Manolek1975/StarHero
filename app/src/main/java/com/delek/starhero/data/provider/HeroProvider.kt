package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.HeroEntity

class HeroProvider {
    companion object {
        fun loadHeroes(context: Context): List<HeroEntity> {
            val heroes = mutableListOf<HeroEntity>()
            val name = context.resources.getStringArray(R.array.name_hero)

            for (i in name.indices) {
                val hero = HeroEntity(
                    i + 1, name[i], "", "", 0, 0,
                    0, 0, 0, 0, 0
                )
                heroes.add(hero)
            }

            return heroes
        }
    }
}