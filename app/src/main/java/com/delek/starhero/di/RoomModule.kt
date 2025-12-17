package com.delek.starhero.di

import android.content.Context
import androidx.room.Room
import com.delek.starhero.data.database.StarHeroDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "db_star_hero"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, StarHeroDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideHeroDao(db: StarHeroDatabase) = db.getHeroDao()

    @Singleton
    @Provides
    fun provideHeroItemDao(db: StarHeroDatabase) = db.getHeroItemDao()

    @Singleton
    @Provides
    fun provideWeaponDao(db: StarHeroDatabase) = db.getWeaponDao()

    @Singleton
    @Provides
    fun provideShipDao(db: StarHeroDatabase) = db.getShipDao()

    @Singleton
    @Provides
    fun provideSkillDao(db: StarHeroDatabase) = db.getSkillDao()

    @Singleton
    @Provides
    fun provideGroupDao(db: StarHeroDatabase) = db.getGroupDao()

    @Singleton
    @Provides
    fun provideNativeDao(db: StarHeroDatabase) = db.getNativeDao()

    @Singleton
    @Provides
    fun provideMonsterDao(db: StarHeroDatabase) = db.getMonsterDao()

    @Singleton
    @Provides
    fun provideRelationDao(db: StarHeroDatabase) = db.getRelationDao()

    @Singleton
    @Provides
    fun provideDwellingDao(db: StarHeroDatabase) = db.getDwellingDao()

    @Singleton
    @Provides
    fun providePowerDao(db: StarHeroDatabase) = db.getPowerDao()

    @Singleton
    @Provides
    fun provideStartPowerDao(db: StarHeroDatabase) = db.getStartPowerDao()

    @Singleton
    @Provides
    fun provideStarDao(db: StarHeroDatabase) = db.getStarDao()

    @Singleton
    @Provides
    fun providePlanetDao(db: StarHeroDatabase) = db.getPlanetDao()

    @Singleton
    @Provides
    fun provideSurfaceDao(db: StarHeroDatabase) = db.getSurfaceDao()

    @Singleton
    @Provides
    fun provideAdviceChitDao(db: StarHeroDatabase) = db.getAdviceChitDao()

    @Singleton
    @Provides
    fun provideTreasureDao(db: StarHeroDatabase) = db.getTreasureDao()

}