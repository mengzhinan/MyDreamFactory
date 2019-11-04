package com.duke.kotlinlearn.learn4.myview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * @Author: duke
 * @DateTime: 2019-11-03 22:02
 * @Description:
 *
 */
class RoundLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : LinearLayout(context, attrs, defStyle) {

    // 容器类控件绘制，需要重写 dispatchDraw 方法
    // 绘制顺序：容器 onDraw -> 子视图的 onDraw -> 容器 dispatchDraw
    public override fun dispatchDraw(canvas: Canvas?) {
        super.dispatchDraw(canvas)

    }

}