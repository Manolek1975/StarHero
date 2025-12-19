package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.TreasureEntity

class TreasureProvider {

    companion object {
        fun loadTreasures(context: Context): List<TreasureEntity> {
            val treasures: MutableList<TreasureEntity> = mutableListOf()
            val name = context.resources.getStringArray(R.array.name_treasures)
            val image = context.resources.getStringArray(R.array.image_treasures)
            val type = context.resources.getStringArray(R.array.type_treasures)
            val damage = context.resources.getStringArray(R.array.damage_treasures)
            val str = context.resources.getStringArray(R.array.str_treasures)
            val def = context.resources.getStringArray(R.array.def_treasures)
            val price = context.resources.getStringArray(R.array.price_treasures)

            for (i in name.indices) {
                val treasure = TreasureEntity(
                    i + 1,
                    name[i],
                    image[i],
                    type[i],
                    damage[i].toInt(),
                    str[i].toInt(),
                    def[i].toInt(),
                    0,
                    0,
                    0,
                    0,
                    price[i].toInt()
                )
                treasures.add(treasure)
            }
            return treasures
        }
    }
}