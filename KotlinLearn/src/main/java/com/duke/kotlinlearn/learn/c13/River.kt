package com.duke.kotlinlearn.learn.c13

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 18:58
 * description: 模版类 - 泛型类
 *
 * 跟 java 的泛型类一样
 *
 */
class River<T>(var name: String, var length: T) {


    fun getInfo(): String {
        var unit: String = when (length) {
            is String -> "􏹚米"
            // Int􏹎、Long、􏹎Float、􏹎Double 都是数字类型的􏺗 􏱼􏴐􏴍􏸗􏸘Number
            is Number -> "m"
            else -> ""
        }
        return "${name} 的长度是 􏱶􏳮􏴸􏱼$length $unit􏵵"
    }


    fun test() {
        // 泛型类调用
        var river1 = River<Int>("长江", 100)

        var river2 = River("长江", 100)


    }

}