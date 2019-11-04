package com.duke.kotlinlearn.learn.c0

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-05 13:52
 * description:
 *
 */
class KotlinLearn4 {


    /**
     * 无输入、输出参数的函数
     */
    fun emptyMethod1() {

    }


    /**
     * 有输入、无输出参数的函数
     */
    fun emptyMethod2(name: String, age: Int) {

    }


    /**
     * 有输入、无输出参数的函数，第一个输入参数可能为空
     */
    fun emptyMethod3(name: String?, age: Int) {
        var msg: String = if (name == null) "无名字" else "有名字"
        var msg2: String = name ?: "无名"
        var length: Int = name?.length ?: -1

//        name = "黎明"
        var length2: Int = name?.length!!


    }

    /**
     * 无返回值的函数，等价返回参数为 :Unit
     */
    fun m1() {


    }

    /**
     * 有返回值的函数
     */
    fun m2(): String {

        return "test"
    }


    /**
     * 默认参数
     */
    fun m3(age: Int, name: String = "默认参数值"): String {

        // 调用方式：如果不想输入默认值，可以不输入
//        m3(22)

        return "$age+$name"
    }

    /**
     * 可选指定默认参数
     */

    fun m4(name: String, address: String = "武汉", streat: String = "北大街") {


        // 调用1
//        m4("李刚")

        // 调用2 只修改第一个默认参数
//        m4("李刚","深圳")

        // 调用3 只修改第二个默认参数
//        m4("李刚", streat = "光谷东")


    }


    /**
     * 可变参数
     */
    fun m5(vararg names: String?) {

        for (name in names) {
            Log.v("name_test", name)
        }

    }


    /**
     * 可变数组参数
     */
    fun m5(vararg arrays: Array<String>) {

        for (array in arrays) {
            for (item in array) {
                Log.v("name_test", item)
            }
        }

    }

}
