@file:Suppress("NOTHING_TO_INLINE", "unused")
@file:JvmName("Util")

package com.dark.splitbutton.util

import android.content.Context
import android.view.View
import android.graphics.drawable.GradientDrawable

/**
 * Sets the view's padding. This version of the method sets all axes to the provided size.
 *
 * @see View.setPadding
 */
public inline fun View.setPadding(size: Int) {
  setPadding(size, size, size, size)
}

/**
 * Extension function for converting density-independent pixels (dp) to pixels (px).
 *
 * This function multiplies the given dp value by the display density of the device and rounds the
 * result to the nearest integer. It can be used to convert dp values to pixels for UI layout
 * calculations.
 *
 * @param dp The value in density-independent pixels to be converted to pixels.
 * @return The value in pixels (px) as an integer.
 */
public inline fun Context.dpToPx(dp: Float): Int {
  return Math.round(dp * this.resources.displayMetrics.density)
}

/**
 * Utility function that simplifies the creation of rounded corner radii for a shape.
 *
 * This function generates a 4-corner rounded radius array where all four corners (top-left,
 * top-right, bottom-right, bottom-left) have the same radius value.
 *
 * @param radius The radius value for all four corners (top-left, top-right, bottom-right,
 *   bottom-left).
 * @return A FloatArray containing the corner radius for each corner.
 */
public inline fun rad(radius: Float): FloatArray {
  return rad(radius, radius, radius, radius)
}

/**
 * Utility function to create a FloatArray representing different corner radii.
 *
 * This function allows you to define specific radius values for each corner of a shape. It returns
 * an array of 8 values, representing the corner radii for each corner (top-left, top-right,
 * bottom-right, bottom-left). Each corner is defined by a pair of values, which can be used to
 * create rounded corner shapes in drawables.
 *
 * @param tl The radius for the top-left corner.
 * @param tr The radius for the top-right corner.
 * @param bl The radius for the bottom-left corner.
 * @param br The radius for the bottom-right corner.
 * @return A FloatArray representing the corner radii for all corners.
 */
public fun rad(tl: Float, tr: Float, bl: Float, br: Float): FloatArray {
  return floatArrayOf(tl, tl, tr, tr, br, br, bl, bl)
}

/**
 * Creates a `GradientDrawable` with rounded corners and a specific background color.
 *
 * This function is used to create a drawable object with rounded corners. The drawable can then be
 * applied as the background to a UI element (e.g., a button or a view). You can specify a custom
 * background color and optionally provide corner radius values for the rounded corners.
 *
 * @param backgroundColor The color of the drawable background (as an integer color value).
 * @param cornerRadius An optional array of corner radii. Each value corresponds to one of the
 *   corners. If null, default radii are applied.
 * @return A `GradientDrawable` with the specified background color and rounded corners.
 */
public fun roundedBackground(backgroundColor: Int, cornerRadius: FloatArray?): GradientDrawable {
  val drawable = GradientDrawable()
  drawable.setColor(backgroundColor)
  drawable.cornerRadii = cornerRadius
  return drawable
}
