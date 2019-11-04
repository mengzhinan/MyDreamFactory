package com.duke.kotlinlearn.learn.c1

import android.content.Context
import android.util.Log
import org.jetbrains.anko.toast

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 16:56
 * description:
 * 在类名后面的构造函数是主构造函数，可以省略 constructor 关键字
 * 在类里面的构造函数是二级构造函数
 * init { } 初始化方法是 主构造函数的初始化方法
 * 如果调用二级构造函数初始化类时，会先调用主构造函数的 init 方法，再调用二级构造函数自己的方法
 * 如果有主构造函数存在，二级构造函数必须调用主构造函数，使用 this 关键字
 */
class Animal4 constructor(context: Context, name: String) {

    init {
        Log.v("Animal4", "init $name")
        context.toast("init $name")
    }

    constructor(context: Context, name: String, address: String)
            : this(context, name) {
        Log.v("Animal4", "second constructor $name")
        context.toast("second constructor $name")
    }

    constructor(context: Context, name: String, address: String, number: Int) : this(context, name) {
        Log.v("Animal4", "second constructor $name")
        context.toast("second constructor $name")
    }


}