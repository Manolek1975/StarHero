package com.delek.starhero.ui.stars

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import androidx.room.Room
import com.delek.starhero.R
import com.delek.starhero.core.Util
import com.delek.starhero.data.database.StarHeroDatabase
import com.delek.starhero.data.repository.StarRepository
import javax.inject.Inject

class DrawStars @Inject constructor(context: Context) : View(context) {
    //Build ROOM database out of Main thread
    private val db = Room.databaseBuilder(context, StarHeroDatabase::class.java, "db_star_hero")
        .allowMainThreadQueries().build()
    private val dao = db.getStarDao()
    private val repo = StarRepository(dao)
    private val star = repo.getStars()
    private val bm = mutableListOf<Bitmap>()
    private val p = Paint()
    private val dm: DisplayMetrics = resources.displayMetrics
    private var x = dm.widthPixels / 2f
    private var y = dm.heightPixels / 2f
    private var dx = x
    private var dy = y
    private var cx = x
    private var cy = y

    private var mScaleFactor = 1f

    private val scaleListener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            mScaleFactor *= detector.scaleFactor
            //Max & Min map scale
            mScaleFactor = 1f.coerceAtLeast(mScaleFactor.coerceAtMost(5f))
            invalidate()
            return true
        }
    }

    private val mScaleDetector = ScaleGestureDetector(context, scaleListener)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        for (s in star.indices) {
            val id = Util.getResId(star[s].image, R.drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, id)
            val scale = Bitmap.createScaledBitmap(bitmap, 40, 40, false)
            bm.add(scale)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //canvas.translate(x, y + 250)
        canvas.apply {
            save()
            scale(mScaleFactor, mScaleFactor)
            setPaint()
            for (t in bm.indices) {
                canvas.drawText(star[t].name, cx + star[t].x - x, cy + star[t].y - 20f - y, p)
                drawBitmap(bm[t],cx + star[t].x - x,cy + star[t].y - y, p)
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
        p.color = Color.WHITE
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        mScaleDetector.onTouchEvent(event)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dx = event.x/mScaleFactor - cx
                dy = event.y/mScaleFactor - cy
                performClick()
            }
            MotionEvent.ACTION_MOVE -> {
                cx = event.x/mScaleFactor - dx
                cy = event.y/mScaleFactor - dy
                invalidate()
            }
        }
        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        //println("pX: $dx, --- pY: $dy")
        return true
    }
}