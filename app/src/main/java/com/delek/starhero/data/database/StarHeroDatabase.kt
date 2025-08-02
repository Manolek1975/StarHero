package com.delek.starhero.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.starhero.data.database.dao.HeroDao
import com.delek.starhero.data.database.dao.WeaponDao
import com.delek.starhero.data.database.entity.HeroEntity
import com.delek.starhero.data.database.entity.WeaponEntity

@Database(
    entities = [
        HeroEntity::class,
        WeaponEntity::class],
    version = 1, exportSchema = false
)
abstract class StarHeroDatabase : RoomDatabase() {

    abstract fun getHeroDao(): HeroDao
    abstract fun getWeaponDao(): WeaponDao

}