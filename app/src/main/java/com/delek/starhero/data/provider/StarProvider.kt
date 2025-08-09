package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.StarEntity

class StarProvider {

    companion object{
        fun loadStars(context: Context): List<StarEntity> {
            val stars = mutableListOf<StarEntity>()
            val name = context.resources.getStringArray(R.array.name_stars)
            //val image = context.resources.getStringArray(R.array.image_stars)
            //val type = context.resources.getStringArray(R.array.type_stars)
            for (i in name.indices) {
                stars.add(StarEntity(i, name[i], "", "", 0, 0))
            }
            return stars
        }
    }
}