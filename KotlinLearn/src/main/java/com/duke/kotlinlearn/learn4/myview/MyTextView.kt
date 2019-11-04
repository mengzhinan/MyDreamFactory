package com.duke.kotlinlearn.learn4.myview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.TextView

/**
 * @Author: duke
 * @DateTime: 2019-11-03 21:57
 * @Description:
 *
 */
class MyTextView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : TextView(context, attrs, defStyle) {
    // 自定义试图要在类名后面添加  @JvmOverloads constructor

    // 基本视图类控件需要重写 onDraw 进行绘制
    public override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }

}