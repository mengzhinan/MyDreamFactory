package com.duke.kotlinlearn.learn.c0

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-05 13:52
 * description:
 *
 */
class KotlinLearn2 {

    /**
     * 结构相等与引用相等：
     * 1、基本数据类型，如整型、浮点型、布尔型、字符串，结构相等与引用相等一样
     * 2、同一个类声明的不同变量，只要有一个属性不相等，结构和引用都不相等
     * 3、同一个类声明的不同变量，若 equlas 检验的每个属性值都相等，则其结构相等，引用不想等
     * 得出结论：
     * 1、结构相等，比较的是内容
     * 2、引用相等，比较的是内容和内存地址
     * 3、基本数据类型和字符串(字符串也是基本数据类型？)比较的是内容和内存地址
     */

    // 结构相等，即内容相等，==。    -> 比较的是内容，同一物
    fun valueEqulas() {
        var a: String = "a"
        // 如果从初始值中得知变量的类型，就不用定义变量类型
        var b = "a"
        var c = a == b
        Log.v("equlas==", " == " + c)
        // kotlin 比较字符串结构相等 ==，不相等 !=，等同与 java 的 equlas()
    }

    // 引用先等，即内容和内存地址相等，===。    -> 比较的是是否为同一物，唯一性
    fun addressEqulas() {
        var a: String = "a"
        var b = "a"
        var c = a === b
        Log.v("equlas==", " === " + c)
        // kotlin 比较字符串引用相等 ===，不相等 !==，等同与 java 的 equlas()

    }


}
