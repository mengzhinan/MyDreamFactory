package com.duke.kotlinlearn.learn4.myview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.viewpager.widget.PagerTabStrip

/**
 * @Author: duke
 * @DateTime: 2019-11-03 21:31
 * @Description:
 *
 */
class CustomPagerTab @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    PagerTabStrip(context, attrs) {
    private var txtColor = Color.BLACK
    private var textSize = 15

    init {
        if (attrs != null) {
//            val attrArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomPagerTab)

//            attrArray.recycle()
        }
    }
}