package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.WeaponEntity

class WeaponProvider {

    companion object{
        fun loadWeapons(context: Context): List<WeaponEntity> {
            val weapons = mutableListOf<WeaponEntity>()
            val name = context.resources.getStringArray(R.array.name_weapons)
            val type = context.resources.getStringArray(R.array.type_weapons)
            val image = context.resources.getStringArray(R.array.image_weapons)

            for (i in name.indices){
                val weapon = WeaponEntity(i+1, name[i], type[i], image[i], 0, 0, 0, 0)
                weapons.add(weapon)
            }
            return weapons
        }
    }
}