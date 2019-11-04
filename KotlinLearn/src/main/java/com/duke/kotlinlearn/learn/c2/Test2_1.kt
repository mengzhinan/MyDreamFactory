package com.duke.kotlinlearn.learn.c2

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 成员属性
 *
 * 定义两个成员属性，保存构造函数输入的值(传统写法 -> 参考 Test2_2 的简化写法)
 *
 */
class Test2_1 @JvmOverloads constructor(name: String, age: Int = 0) {

    var name: String = name
    val age: Int = age

    init {
        Log.v("", "name = $name , age = $age")
    }


}
