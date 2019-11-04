package com.duke.kotlinlearn.learn.c1

import android.content.Context
import android.util.Log
import org.jetbrains.anko.toast

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 16:56
 * description:
 * 主构造函数可以省略
 * 无论调用哪个构造函数，都会先调用 init 方法(如果 init 方法存在)
 */
class Animal5 {

    init {
        Log.v("Animal4", "init")
    }

    constructor(context: Context, name: String) {
        Log.v("Animal4", "first constructor $name")
        context.toast("first constructor $name")
    }

    constructor(context: Context, age: Int, name: String, address: String) {
        Log.v("Animal4", "second constructor $name")
        context.toast("second constructor $name")
    }


}
