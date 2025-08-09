package com.delek.starhero.ui.stars

import android.content.Context
import android.view.View
import androidx.room.Room
import com.delek.starhero.data.database.StarHeroDatabase
import com.delek.starhero.data.repository.StarRepository
import javax.inject.Inject

class DrawStars @Inject constructor(context: Context) : View(context) {

    private val db = Room.databaseBuilder(context, StarHeroDatabase::class.java, "db_starhero")
        .allowMainThreadQueries().build()
    private val dao = db.getStarDao()
    private val repo = StarRepository(dao)
    private val tiles = repo.getStars()
}