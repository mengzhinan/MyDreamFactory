package com.duke.kotlinlearn.learn3.application

import android.app.Application

/**
 * @Author: duke
 * @DateTime: 2019-11-03 19:56
 * @Description:
 *
 */
class App2 : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private lateinit var instance: App2
        fun instance() = instance
    }
}