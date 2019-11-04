package com.duke.kotlinlearn.learn4.runnable

import android.os.Handler

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-04 09:18
 * description: 匿名内部类 Demo
 *
 */
class Runnable2 {

    private val handler = Handler()
    private var count = 0

    // 使用关键字 object 占位，表示这是一个匿名内部类
    private val counter = object : Runnable {
        override fun run() {
            count++
            handler.postDelayed(this, 1000)
        }
    }

    fun postMessage() {
        handler.post(counter)
    }

}