package com.duke.kotlinlearn.learn4.runnable

import android.os.Handler

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-04 09:18
 * description: 简写匿名内部类 Demo
 *
 */
class Runnable4 {

    private val handler = Handler()
    private var count = 0

    // 把类的继承与方法重载步骤给简化类，
    // 代价是不能使用 this 指代自身，不能执行重复任务
    private val counter = Runnable {
        count++
//        handler.postDelayed(this, 1000)
    }

    fun postMessage() {
        // 一次性任务
        handler.post(counter)
    }

}
