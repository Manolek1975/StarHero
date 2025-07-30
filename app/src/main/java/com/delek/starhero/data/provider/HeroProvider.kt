package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.HeroEntity

class HeroProvider {
    companion object {
        fun loadHeroes(context: Context): List<HeroEntity> {
            val heroes = mutableListOf<HeroEntity>()
            val name = context.resources.getStringArray(R.array.name_hero)
            val image = context.resources.getStringArray(R.array.image_hero)
            val size = context.resources.getStringArray(R.array.size_hero)
            val strength = context.resources.getStringArray(R.array.strength_hero)

            for (i in name.indices) {
                val hero = HeroEntity(
                    i + 1, name[i], image[i], "", size[i], 0,
                    strength[i].toInt(), 0, 0, 0, 0
                )
                heroes.add(hero)
            }

            return heroes
        }
    }
}