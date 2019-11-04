package com.duke.kotlinlearn.learn4.myview

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

/**
 * @Author: duke
 * @DateTime: 2019-11-03 21:45
 * @Description:
 *
 */
class NoScrollListView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : ListView(context, attrs, defStyle) {

    public override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // >> 2，位移在 kotlin 中是 shr 2
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr 2, MeasureSpec.AT_MOST)
        super.onMeasure(widthMeasureSpec, expandSpec)
    }

}