package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.StartPowerEntity

class StartPowerProvider {

    companion object{
        fun loadStartPowers(context: Context): List<StartPowerEntity> {
            val powers = mutableListOf<StartPowerEntity>()
            val heroId = context.resources.getStringArray(R.array.hero_id_start_powers)
            val typeId = context.resources.getStringArray(R.array.type_id_start_powers)
            val powerType = context.resources.getStringArray(R.array.type_start_power)
            for (i in heroId.indices) {
                val entity = StartPowerEntity(i + 1, heroId[i].toInt(), typeId[i].toInt(), powerType[i])
                powers.add(entity)
            }
            return powers

        }
    }
}