package com.dark.splitbtn

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.view.setPadding
import com.dark.splitbtn.util.UI
import com.google.android.material.button.MaterialButton

class SplitButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private lateinit var ui: UI
    private var childBackgroundColor: Int = Color.LTGRAY
    private var cornerRadius: Float = 50f
    private var corner2: Float = 8f
    private var childSpacing: Int = 5
    private var childTxtColor: Int = Color.DKGRAY

    init {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        ui = UI(context)
        setPadding(ui.dpToPx(8f))

        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SplitButton)
            childBackgroundColor =
                typedArray.getColor(R.styleable.SplitButton_childBackgroundColor, Color.LTGRAY)
            childTxtColor =
                typedArray.getColor(R.styleable.SplitButton_childTextColor, Color.DKGRAY)
            cornerRadius = typedArray.getFloat(
                R.styleable.SplitButton_edgeCorner, ui.dpToPx(50F).toFloat()
            )
            corner2 =
                typedArray.getFloat(R.styleable.SplitButton_childCorner, ui.dpToPx(8F).toFloat())
            childSpacing = typedArray.getDimensionPixelSize(R.styleable.SplitButton_childSpacing, 5)
            typedArray.recycle()
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        val childCount = childCount
        if (childCount > 1) {
            val firstChild = getChildAt(0) as? MaterialButton ?: return
            setupChildView(firstChild, isFirst = true)

            val lastChild = getChildAt(childCount - 1) as? MaterialButton ?: return
            setupChildView(lastChild, isLast = true)

            for (i in 1 until childCount - 1) {
                val middleChild = getChildAt(i) as? MaterialButton ?: continue
                setupChildView(middleChild)
            }
        }
    }

    private fun setupChildView(
        child: MaterialButton, isFirst: Boolean = false, isLast: Boolean = false
    ) {
        val params = child.layoutParams as? MarginLayoutParams ?: return
        params.marginEnd = childSpacing

        if (isFirst) {
            child.background = ui.setBackground(
                childBackgroundColor, ui.rad(cornerRadius, corner2, cornerRadius, corner2)
            )
        } else if (isLast) {
            child.background = ui.setBackground(
                childBackgroundColor, ui.rad(corner2, cornerRadius, corner2, cornerRadius)
            )
        } else {
            child.background = ui.setBackground(childBackgroundColor, ui.rad(corner2))
        }

        child.backgroundTintList = ColorStateList.valueOf(childBackgroundColor)
        child.setTextColor(childTxtColor)
        child.layoutParams = params
    }

    override fun addView(child: View?) {
        suppressLayout(true)
        super.addView(child)
        suppressLayout(false)
        child?.let { fadeInView(it) }
    }

    override fun addView(child: View?, index: Int) {
        suppressLayout(true)
        super.addView(child, index)
        suppressLayout(false)
        child?.let { fadeInView(it) }
    }

    override fun removeView(view: View?) {
        view?.let {
            fadeOutView(it) {
                suppressLayout(true)
                super.removeView(it)
                suppressLayout(false)
            }
        }
    }

    override fun removeViewAt(index: Int) {
        getChildAt(index)?.let {
            fadeOutView(it) {
                suppressLayout(true)
                super.removeViewAt(index)
                suppressLayout(false)
            }
        }

    }

    private fun updateChildViews() {
        val childCount = childCount
        if (childCount > 1) {
            val firstChild = getChildAt(0) as? MaterialButton ?: return
            setupChildView(firstChild, isFirst = true)

            val lastChild = getChildAt(childCount - 1) as? MaterialButton ?: return
            setupChildView(lastChild, isLast = true)

            for (i in 1 until childCount - 1) {
                val middleChild = getChildAt(i) as? MaterialButton ?: continue
                setupChildView(middleChild)
            }
        }
    }


    fun addNewButton(string: String) {
        val materialButton = MaterialButton(context).apply {
            text = string
            setTextColor(childTxtColor)
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT
            ).apply {
                marginEnd = childSpacing
            }
        }

        suppressLayout(true) // Prevent unnecessary re-layouts
        addView(materialButton, 0) // Add the new button at the start
        updateChildViews()
        suppressLayout(false)
    }


    private fun fadeInView(view: View) {
        view.alpha = 0f
        view.animate().alpha(1f).setDuration(300).start()
    }

    private fun fadeOutView(view: View, onAnimationEnd: (() -> Unit)? = null) {
        view.animate().alpha(0f).setDuration(300).withEndAction {
            onAnimationEnd?.invoke()
        }.start()
    }

}
