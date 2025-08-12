package com.delek.starhero.ui.stars

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.view.View
import androidx.room.Room
import com.delek.starhero.data.database.StarHeroDatabase
import com.delek.starhero.data.repository.StarRepository
import javax.inject.Inject

class DrawStars @Inject constructor(context: Context) : View(context) {
    //Build ROOM database out of Main thread
    private val db = Room.databaseBuilder(context, StarHeroDatabase::class.java, "db_star_hero")
        .allowMainThreadQueries().build()
    private val dao = db.getStarDao()
    private val repo = StarRepository(dao)
    private val stars = repo.getStars()
    private val p = Paint()


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.apply {
            save()
            setPaint()
            //canvas.drawBitmap(bitmap, 0f, 0f, null)
            for (s in stars) {
                val x1 = s.x.toFloat()
                val y1 = s.y.toFloat()

                //canvas.drawText(s.name +":"+ x1 +","+ y1, x1, y1 - 20, p)
                canvas.drawText(s.name, x1, y1 - 20, p)
                setColorType(s.type)
                canvas.drawCircle(x1, y1, 15F, p)
                p.color = Color.WHITE
            }
            restore()
        }
        invalidate()
        db.close()
    }

    private fun setPaint() {
        //val tf = Typeface.createFromAsset(context.assets, "font/macondo.ttf")
        p.setTypeface(Typeface.DEFAULT_BOLD)
        p.isAntiAlias = true
        p.textSize = 32f
        p.textAlign = Paint.Align.CENTER
    }

    private fun setColorType(char: String){
        when (char) {
            "S" -> p.color = Color.YELLOW
            "A" -> p.color = Color.CYAN
            "R" -> p.color = Color.RED
            "B" -> p.color = Color.WHITE
        }
    }
}