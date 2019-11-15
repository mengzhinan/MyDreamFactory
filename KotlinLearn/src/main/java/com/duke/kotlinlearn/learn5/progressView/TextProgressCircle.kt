package com.duke.kotlinlearn.learn5.progressView

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-15 09:26
 * description:
 * 自定义视图要在类名后面增加 @JvmOverloads constructor，
 * 因为布局文件中的自定义视图必须兼容 Java
 */
class TextProgressCircle @JvmOverloads constructor(
    private val mContext: Context,
    attr: AttributeSet? = null
) : View(mContext, attr) {

    private val paintBack: Paint = Paint()
    private val paintFore: Paint = Paint()
    private val paintText: Paint = Paint()


    private var lineWidth = 10
    private var lineColor = Color.GREEN
    private var mTextSize = 50.0F

    private lateinit var mRect: RectF
    private var mProgress = 0

    init {
        // 初始化背景画笔的相关属性
        paintBack.isAntiAlias = true
        paintBack.color = Color.LTGRAY
        paintBack.strokeWidth = lineWidth.toFloat()
        paintBack.style = Paint.Style.STROKE

        // 初始化前景画笔的相关属性
        paintFore.isAntiAlias = true
        paintFore.color = lineColor
        paintFore.strokeWidth = lineWidth.toFloat()
        paintFore.style = Paint.Style.STROKE

        // 初始化文本画笔的相关属性
        paintText.isAntiAlias = true
        paintText.color = Color.BLUE
        paintText.textSize = mTextSize

    }

    // 重写 onDraw 绘制函数，绘制圆圈背景、圆圈前景，以及中央的进度文本
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val width = measuredWidth
        val height = measuredHeight
        if (width <= 0 || height <= 0) {
            return
        }

        val diameter = Math.min(width, height)
        mRect = RectF(
            ((width - diameter) / 2 + lineWidth).toFloat(),
            ((height - diameter) / 2 + lineWidth).toFloat(),
            ((width + diameter) / 2 - lineWidth).toFloat(),
            ((height + diameter) / 2 - lineWidth).toFloat()
        )

        // 绘制进度圆圈的背景，背景是完整的圆环
        canvas?.drawArc(mRect, 0F, 360F, false, paintBack)

        // 绘制进度圆圈的前景，前景是实际进度占 360 度的百分比
        canvas?.drawArc(mRect, 0F, (mProgress * 360 / 100).toFloat(), false, paintFore)

        val text = "$mProgress%"
        val rect = Rect()

        // 获得进度文本的矩形边界
        paintText.getTextBounds(text, 0, text.length, rect)
        val x = getWidth() / 2 - rect.centerX()
        val y = getHeight() / 2 - rect.centerY()

        // 把文本内容绘制在进度圆圈的圆心位置
        canvas?.drawText(text, x.toFloat(), y.toFloat(), paintText)

    }

    // 设置进度数值以及进度文本的文字大小
    fun setProgress(progress: Int, textSize: Float) {
        mProgress = progress
        if (textSize > 0) {
            mTextSize = textSize
            paintText.textSize = mTextSize
        }
        invalidate()
    }

    // 设置进度圆圈的线宽与颜色
    fun setProgressStyle(lineWidthVar: Int, lineColorVar: Int) {
        if (lineWidthVar > 0) {
            lineWidth = lineWidthVar
            paintFore.strokeWidth = lineWidth.toFloat()
        }
        if (lineColorVar > 0) {
            lineColor = lineColorVar
            paintFore.color = lineColor
        }
        invalidate()
    }


}