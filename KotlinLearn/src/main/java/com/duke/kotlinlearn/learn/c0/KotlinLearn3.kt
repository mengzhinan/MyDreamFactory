package com.duke.kotlinlearn.learn.c0

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-05 13:52
 * description:
 *
 */
class KotlinLearn3 {


    /**
     * 类型比较
     */
    fun isOf() {
        var str: String = ""
        var bl: Boolean = str is String
    }

    fun isNotOf() {
        var str: String = ""
        var bl: Boolean = str !is String
    }

    /**
     * 是否包含某一元素
     */
    fun inOrNotOf() {
        val oneArray: IntArray = intArrayOf(1, 2, 3, 4, 5)
        val four: Int = 4
        val nine: Int = 9
        var count = 1
        when (count++ % 4) {
            0 -> {
                // in 用于判断变量是否位于数组或容器中
                val result = four in oneArray
            }
            1 -> {
                val result = four !in oneArray
            }
            2 -> {
                val result = nine in oneArray
            }
            else -> {
                val result = nine !in oneArray
            }
        }


    }








}
