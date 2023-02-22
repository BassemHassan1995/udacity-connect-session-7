package com.bassem.session7.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

abstract class CustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    abstract val paint: Paint

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawShape()
    }

    abstract fun Canvas.drawShape()

}