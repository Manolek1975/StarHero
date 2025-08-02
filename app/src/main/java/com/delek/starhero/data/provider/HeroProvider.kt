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
            val icon = context.resources.getStringArray(R.array.icon_hero)
            val size = context.resources.getStringArray(R.array.size_hero)
            val weapon = context.resources.getStringArray(R.array.weapon_hero)
            val strength = context.resources.getStringArray(R.array.strength_hero)
            val defense = context.resources.getStringArray(R.array.defense_hero)
            val health = context.resources.getStringArray(R.array.health_hero)
            val speed = context.resources.getStringArray(R.array.speed_hero)
            val power = context.resources.getStringArray(R.array.power_hero)
            for (i in name.indices) {
                val hero = HeroEntity(
                    i + 1, name[i], image[i], icon[i], size[i], 0, weapon[i].toInt(),
                    strength[i].toInt(), defense[i].toInt(), health[i].toInt(),
                    speed[i].toInt(), power[i].toInt(),0
                )
                heroes.add(hero)
            }

            return heroes
        }
    }
}