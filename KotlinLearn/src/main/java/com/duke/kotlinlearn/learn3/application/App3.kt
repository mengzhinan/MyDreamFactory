package com.duke.kotlinlearn.learn3.application

import android.app.Application
import kotlin.properties.Delegates

/**
 * @Author: duke
 * @DateTime: 2019-11-03 19:56
 * @Description:
 *
 */
class App3 : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: App3 by Delegates.notNull()
        fun instance() = instance
    }
}