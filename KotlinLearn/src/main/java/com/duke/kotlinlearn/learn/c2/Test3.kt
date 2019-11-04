package com.duke.kotlinlearn.learn.c2

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 成员属性
 *
 *
 *
 */
class Test3 @JvmOverloads constructor(var name: String, val age: Int = 0) {

    // 非同名属性
    // 非空的成员属性，必须赋予初始值，或在构造函数中赋值
    var learnName: String

    init {
        learnName = if (age == 0) "无上学" else "上小学"
        Log.v("", "name = $name , age = $age")

    }

    fun test() {

        // 创建和调用方式
        var test2 = Test3("AAA")
        var msg = test2.name
        var num = test2.age

    }


}
