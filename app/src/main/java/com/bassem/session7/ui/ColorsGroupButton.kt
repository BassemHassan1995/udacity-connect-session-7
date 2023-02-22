package com.bassem.session7.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.bassem.session7.R
import com.bassem.session7.utils.CustomView

class ColorsGroupButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CustomView(context, attrs, defStyleAttr) {

    var colorsType: String = ""
        set(value) {
            field = value
            invalidate()
        }

    var isGroupShown = false
        set(value) {
            field = value
            invalidate()
        }

    override val paint: Paint
        get() = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = Color.GRAY
        }

    override fun Canvas.drawShape() {
        drawBackgroundColor()
        drawButtonText()
        drawIcon()
    }

    private fun Canvas.drawBackgroundColor() {
        val rectangle = Rect(0, 0, width, height)
        drawRect(rectangle, paint)
    }

    private fun Canvas.drawButtonText() {
        val buttonText = if (isGroupShown) {
            R.string.hide_colors
        } else
            R.string.show_colors

        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            textAlign = Paint.Align.CENTER
            textSize = 50.0f
            color = Color.WHITE
        }

        drawText(
            resources.getString(buttonText, colorsType),
            width / 2f,
//            height / 2 - (textPaint.descent() + textPaint.ascent()) / 2,
            height / 2 + (textPaint.textSize / 2),      //Simpler way
            textPaint
        )
    }

    private fun Canvas.drawIcon() {
        val rectangleAtTheEnd = Rect(width - height, 0, width, height)
        val rectangleAtTheStart = Rect(0, 0, height, height)
        val colorBitmap = ContextCompat.getDrawable(context, R.drawable.ic_colors)?.toBitmap()
        colorBitmap?.let {
            drawBitmap(it, null, rectangleAtTheStart, paint)
        }
    }

    fun setViewData(colorType: String, onShowClick : () -> Unit, onHideClick : () -> Unit){
        colorsType = colorType
        setOnClickListener {
            isGroupShown = if (isGroupShown) {
                onHideClick()
                false
            }
            else
            {
                onShowClick()
                true
            }
        }
    }
}