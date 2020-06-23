package gsihome.reyst.supertv

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class SuperTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.style.SuperTextView
) : AppCompatTextView(context, attrs, defStyleAttr) {


    init {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SuperTextView, 0, defStyleAttr)
        try {
            applyAttrs(a)
        } finally {
            a.recycle()
        }
    }

    @SuppressLint("CustomViewStyleable")
    @Suppress("DEPRECATION")
    private fun applyAttrs(a: TypedArray) {

        val colorAppearanceId = a.getResourceId(R.styleable.SuperTextView_textColorAppearance, R.style.TextColorAppearance)
        val ta: TypedArray = context.obtainStyledAttributes(colorAppearanceId, R.styleable.SuperTextViewColorAppearance)

        try {
            setTextColor(
                ta.getColor(
                    R.styleable.SuperTextViewColorAppearance_superTextColor,
                    resources.getColor(R.color.super_tv_text_color)
                )
            )
        } finally {
            ta.recycle()
        }
    }
}