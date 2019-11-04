package com.duke.kotlinlearn.learn2.d0

import android.widget.Button
import org.jetbrains.anko.dip
import org.jetbrains.anko.toast

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-10 09:43
 * description: Button 点击、长按 事件
 *
 */
class Button1 {


    fun button1(btn: Button) {

        btn.setOnClickListener { btn.text = "点击了" }

        btn.setOnLongClickListener {
            btn.text = "长按了1"
            true
        }

        btn.setOnLongClickListener { btn.text = "长按了2";true }

    }

    fun button2(btn: Button) {

        btn.setOnClickListener { v ->
            v.context.toast("点击了，按钮名称：􏳩􏳪􏼁􏳫􏼄􏱵􏳴${(v as Button).text}")
        }

        // 获取 dip 值
        var dpValue = btn.dip(20)

    }

}