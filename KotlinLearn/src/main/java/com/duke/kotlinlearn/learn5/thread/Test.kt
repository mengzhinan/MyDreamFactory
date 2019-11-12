package com.duke.kotlinlearn.learn5.thread

/**
 * @Author: duke
 * @DateTime: 2019-11-12 22:20
 * @Description:
 *
 */
class Test {

    fun start1(){
        MyThread().start()
    }

    fun start2(){
        Thread {

        }.start()
    }

}