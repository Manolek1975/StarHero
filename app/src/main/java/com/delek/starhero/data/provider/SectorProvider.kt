package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.SectorEntity

class SectorProvider {

    companion object{
        fun loadStars(context: Context): List<SectorEntity> {
            val stars = mutableListOf<SectorEntity>()
            val name = context.resources.getStringArray(R.array.name_stars)
            val image = context.resources.getStringArray(R.array.image_stars)
            val type = context.resources.getStringArray(R.array.type_stars)
            val x = context.resources.getStringArray(R.array.star_x)
            val y = context.resources.getStringArray(R.array.star_y)

            name.shuffle()

            for (i in name.indices) {
                stars.add(SectorEntity(i+1, name[i], image[i], type[i], x[i].toInt(), y[i].toInt()))
            }
            return stars
        }
    }
}