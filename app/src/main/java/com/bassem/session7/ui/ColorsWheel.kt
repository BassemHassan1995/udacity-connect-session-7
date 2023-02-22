package com.bassem.session7.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bassem.session7.utils.CustomView

class ColorsWheel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CustomView(context, attrs, defStyleAttr) {

    private var colorsMap = mapOf<Int, Int>()
        set(value) {
            field = value
            invalidate()
        }

    fun addColorMap(map: Map<Int, Int>) {
        colorsMap += map
        //Alternatives with the same result:
        //colorsMap = colorsMap.plus(map)
        //colorsMap = colorsMap + map
    }

    fun removeColorMap(map: Map<Int, Int>) {
        colorsMap -= map.keys

        //Alternatives with the same result:
        //colorsMap = colorsMap.minus(map.keys)
    }

    override val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
    }

    override fun Canvas.drawShape() {
        with(colorsMap) {
            val sectorSize = 360f / size

            onEachIndexed { index, entry ->
                drawColorArc(entry.key, sectorSize * index, sectorSize)
            }
        }
    }

    private fun Canvas.drawColorArc(@ColorRes color: Int, startAngle: Float, sweepAngle: Float) {
        val rectF = RectF(
            0f,
            0f,
            width.toFloat(),
            width.toFloat()
        )
        paint.color = ContextCompat.getColor(context, color)
        drawArc(rectF, startAngle, sweepAngle, true, paint)
    }
}