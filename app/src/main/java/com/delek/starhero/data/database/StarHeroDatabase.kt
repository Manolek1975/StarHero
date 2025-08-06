package com.delek.starhero.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.delek.starhero.data.database.dao.DwellingDao
import com.delek.starhero.data.database.dao.HeroDao
import com.delek.starhero.data.database.dao.GroupDao
import com.delek.starhero.data.database.dao.RelationDao
import com.delek.starhero.data.database.dao.ShipDao
import com.delek.starhero.data.database.dao.SkillDao
import com.delek.starhero.data.database.dao.WeaponDao
import com.delek.starhero.data.database.entity.DwellingEntity
import com.delek.starhero.data.database.entity.HeroEntity
import com.delek.starhero.data.database.entity.GroupEntity
import com.delek.starhero.data.database.entity.RelationEntity
import com.delek.starhero.data.database.entity.ShipEntity
import com.delek.starhero.data.database.entity.SkillEntity
import com.delek.starhero.data.database.entity.WeaponEntity

@Database(
    entities = [
        HeroEntity::class,
        WeaponEntity::class,
        ShipEntity::class,
        SkillEntity::class,
        GroupEntity::class,
        RelationEntity::class,
        DwellingEntity::class],
    version = 1, exportSchema = false
)
abstract class StarHeroDatabase : RoomDatabase() {

    abstract fun getHeroDao(): HeroDao
    abstract fun getWeaponDao(): WeaponDao
    abstract fun getShipDao(): ShipDao
    abstract fun getSkillDao(): SkillDao
    abstract fun getGroupDao(): GroupDao
    abstract fun getRelationDao(): RelationDao
    abstract fun getDwellingDao(): DwellingDao

}