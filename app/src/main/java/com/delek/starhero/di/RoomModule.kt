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
    fun provideWeaponDao(db: StarHeroDatabase) = db.getWeaponDao()

    @Singleton
    @Provides
    fun provideShipDao(db: StarHeroDatabase) = db.getShipDao()

    @Singleton
    @Provides
    fun provideSkillDao(db: StarHeroDatabase) = db.getSkillDao()
}