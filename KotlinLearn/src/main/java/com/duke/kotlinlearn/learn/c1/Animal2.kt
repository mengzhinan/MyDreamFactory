package com.duke.kotlinlearn.learn.c1

import android.content.Context
import android.util.Log
import org.jetbrains.anko.toast

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 16:21
 * description:
 * 主构造函数1 + 主构造函数的初始化部分
 */
class Animal2 constructor(context: Context, age: Int, name: String) {
    // 类的初始化函数
    init {

        // Kotlin 使用 println 代替 System.out.println()
        Log.v("Animaltest", "Animal init")
        context.toast("")
    }

}


