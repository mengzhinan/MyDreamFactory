package com.duke.kotlinlearn.learn3.application

import android.app.Application
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @Author: duke
 * @DateTime: 2019-11-03 19:56
 * @Description:
 *
 */
class App4 : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        // 定义一个非空且只能赋值一次的属性
        private var instance: App4 by NotNullSingleValueVar()

        fun instance() = instance
    }

    private class NotNullSingleValueVar<T> : ReadWriteProperty<Any?, T> {
        private var value: T? = null
        override fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return value ?: throw IllegalStateException("application no t initialized")
        }

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = if (this.value == null) value
            else throw IllegalStateException("application already initi alized")
        }
    }
}