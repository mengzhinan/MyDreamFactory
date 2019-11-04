package com.duke.kotlinlearn.learn.c2

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 成员属性
 *
 * 在构造函数 name 前面添加 var 关键字，表示给该类定义 name 可变成员属性，并自动赋值
 * 在构造函数 age 前面添加 val 关键字，表示给该类定义 age 不可变成员属性，并自动复制
 * 这事针对同名属性的情况。如果不是同名属性，请看后面的例子
 */
class Test2_2 @JvmOverloads constructor(var name: String, val age: Int = 0) {

    init {
        Log.v("", "name = $name , age = $age")

    }

    fun test() {

        // 创建和调用方式
        var test2 = Test2_2("AAA")
        var msg = test2.name
        var num = test2.age

    }


}
