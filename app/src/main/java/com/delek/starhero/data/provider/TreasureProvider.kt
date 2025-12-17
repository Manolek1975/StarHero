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

            for (i in name.indices) {
                val treasure = TreasureEntity(i + 1, name[i], image[i], 0, 0, 0, 0, 0, 0,0)
                treasures.add(treasure)
            }
            return treasures
        }
    }
}