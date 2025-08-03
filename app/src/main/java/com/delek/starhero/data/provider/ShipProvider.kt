package com.delek.starhero.data.provider

import android.content.Context
import com.delek.starhero.R
import com.delek.starhero.data.database.entity.ShipEntity

class ShipProvider {

    companion object{
        fun loadShips(context: Context): List<ShipEntity> {
            val ships = mutableListOf<ShipEntity>()
            val name = context.resources.getStringArray(R.array.name_ships)
            val image = context.resources.getStringArray(R.array.image_ships)

            for(i in name.indices) {
                val ship = ShipEntity(i+1, name[i], image[i], "",0,0, 0)
                ships.add(ship)
            }
            return ships
        }
    }
}