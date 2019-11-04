package com.duke.kotlinlearn.learn.c1

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 16:21
 * description:
 * 主构造函数2 + 主构造函数初始化部分
 */
class Animal3(age: Int, name: String) {
    // 类的初始化函数
    init {

        // Kotlin 使用 println 代替 System.out.println()
        Log.v("Animaltest", "Animal init")
    }

}


