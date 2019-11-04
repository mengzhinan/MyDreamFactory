package com.duke.kotlinlearn.learn.c0

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-05 13:52
 * description:
 *
 */
class KotlinLearn5 {


    /**
     * 泛型函数
     */
    fun <T> appendString(tag: String, vararg otherInfo: T?): String {
        var str: String = "$tag􏳴"
        for (item in otherInfo) {
            str = "$str${item.toString()}􏱹"
        }

        // 泛型函数调用
//        var resultStr  = appendString("tagvalue", 1,2,3)

        return str
    }


    /**
     * 内联函数
     */

    inline fun <reified T : Number> testMethod(array: Array<T>) {
        for (item in array) {
            Log.v("log_test", "" + item.toString())
        }
    }


    /**
     * 简化函数，可以使用等号给函数赋值，如果函数的表达式简单
     */

    fun factorial(n: Int): Int = if (n <= 1) n else n * factorial(n - 1)


    /**
     * 尾递归函数，tailrec
     */
    tailrec fun findFixPoint(x: Double = 1.0): Double = if (x == Math.cos(x)) x else findFixPoint(Math.cos(x))


    /**
     * 高阶函数
     */
    fun <T> maxCustom(array: Array<T>, greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in array) {
            // 如果 item 大于 max， greater 返回 true
            if (max == null || greater(item, max)) {
                max = item
            }

        }
        return max
    }

    /**
     * 调用高阶函数
     */
    fun callMaxCustom() {

        var max: Int? = maxCustom<Int>(arrayOf(1, 2, 3, 4, 5), { a, b -> a > b })

    }


    /**
     * 扩展函数
     */
    fun <T> Array<T>.swap(pos1: Int, pos2: Int) {
        val temp = this[pos1]
        this[pos1] = this[pos2]
        this[pos2] = temp
    }

    /**
     * 扩展函数调用
     */
    fun extraMethodCall() {
        var array: Array<Double> = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
        array.swap(0, 4)
        for (a in array) {
            Log.v("testlog", "item = $a")
        }

    }


    /**
     * 扩展泛型高阶函数
     */
    fun <T> Array<T>.maxCustomize(greater: (T, T) -> Boolean): T? {
        var max: T? = null
        for (item in this) {
            if (max == null || greater(item, max)) {
                max = item
            }
        }
        return max
    }

    /**
     * 扩展泛型高阶函数 -> 调用
     */
    fun callMaxCustomize() {

        var array: Array<String> = arrayOf("A", "AB", "ABC", "BCD")
        var resultStr: String? = array.maxCustomize({ a, b -> a > b })

    }

}





