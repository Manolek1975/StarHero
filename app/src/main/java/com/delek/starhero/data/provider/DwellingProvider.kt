package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.DwellingEntity

class DwellingProvider {

    companion object{
        fun loadDwellings(context: Context): List<DwellingEntity> {
            val dwellings = mutableListOf<DwellingEntity>()
            val name = context.resources.getStringArray(R.array.name_dwellings)
            val image = context.resources.getStringArray(R.array.image_dwellings)
            for (i in name.indices) {
                dwellings.add(DwellingEntity(i, name[i], image[i]))
            }
            return dwellings
        }
    }
}