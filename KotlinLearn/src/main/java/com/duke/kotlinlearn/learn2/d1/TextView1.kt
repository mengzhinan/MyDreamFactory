package com.duke.kotlinlearn.learn2.d1

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.view.Gravity
import android.widget.TextView

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-16 16:42
 * description:
 *
 */
class TextView1 {

    /**
     * 跑马灯效果
     */
    fun marqueeText(context: Context){

        var textView :TextView = TextView(context)
        textView.text = "测试信息：跑马灯效果广告，需要单行长内容的效果。"
        textView.textSize = 17f
        textView.setTextColor(Color.BLACK)
        textView.setBackgroundColor(Color.WHITE)
        textView.gravity = Gravity.LEFT or Gravity.CENTER
        textView.ellipsize = TextUtils.TruncateAt.MARQUEE
        textView.setSingleLine(true)
        textView.isFocusable = true
        textView.isFocusableInTouchMode = true


    }

}