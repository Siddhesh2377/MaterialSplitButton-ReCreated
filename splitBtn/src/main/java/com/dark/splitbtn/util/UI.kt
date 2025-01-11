package com.dark.splitbtn.util

import android.content.Context
import android.graphics.drawable.GradientDrawable

class UI(private val context: Context) {
    fun setBackground(backgroundColor: Int, cornerRadius: FloatArray?): GradientDrawable {
        val drawable = GradientDrawable()
        drawable.setColor(backgroundColor)
        drawable.cornerRadii = cornerRadius
        return drawable
    }

    fun dpToPx(dp: Float): Int {
        return Math.round(dp * context.resources.displayMetrics.density)
    }

    fun rad(r: Float): FloatArray {
        return floatArrayOf(r, r, r, r, r, r, r, r)
    }

    fun rad(tl: Float, tr: Float, bl: Float, br: Float): FloatArray {
        return floatArrayOf(tl, tl, tr, tr, br, br, bl, bl)
    }
}
