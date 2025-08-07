package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.PowerEntity

class PowerProvider {

    companion object {
        fun loadPowers(context: Context): List<PowerEntity> {
            val powers = mutableListOf<PowerEntity>()
            val name = context.resources.getStringArray(R.array.power_name)
            val type = context.resources.getStringArray(R.array.power_type)
            val color = context.resources.getStringArray(R.array.power_color)
            val target = context.resources.getStringArray(R.array.power_target)
            val duration = context.resources.getStringArray(R.array.power_duration)
            val typeName = context.resources.getStringArray(R.array.power_type_name)
            val description = context.resources.getStringArray(R.array.power_description)
            val shortDescription = context.resources.getStringArray(R.array.power_short_description)

            for (i in name.indices) {
                val value = PowerEntity(
                    i + 1, name[i], type[i], color[i],
                    target[i], duration[i], typeName[i], description[i], shortDescription[i]
                )
                powers.add(value)

            }
            return powers
        }
    }

}