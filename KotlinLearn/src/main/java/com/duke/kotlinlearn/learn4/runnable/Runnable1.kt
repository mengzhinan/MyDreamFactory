package com.duke.kotlinlearn.learn4.runnable

import android.os.Handler

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-04 09:18
 * description: 内部类 Demo
 *
 */
class Runnable1 {


    private val handler = Handler()
    private var count = 0

    // inner 修饰符表示这是一个内部类
    private inner class Counter : Runnable {
        override fun run() {
            count++
            handler.postDelayed(this, 1000)
        }
    }


    fun postMessage() {
        handler.post(Counter())
    }

}