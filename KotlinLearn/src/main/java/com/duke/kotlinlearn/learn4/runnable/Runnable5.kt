package com.duke.kotlinlearn.learn4.runnable

import android.os.Handler

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-04 09:18
 * description: 简写匿名内部类 Demo
 *
 */
class Runnable5 {

    private val handler = Handler()
    private var count = 0

    fun postMessage() {
        // 一次性任务
        handler.post(Runnable {
            count++
//        handler.postDelayed(this, 1000)
        })

        handler.post( {
            count++
//        handler.postDelayed(this, 1000)
        })

        handler.post {
            count++
//        handler.postDelayed(this, 1000)
        }
    }

}
