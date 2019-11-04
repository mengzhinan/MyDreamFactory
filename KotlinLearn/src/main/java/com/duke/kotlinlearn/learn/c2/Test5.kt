package com.duke.kotlinlearn.learn.c2

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 成员方法
 *
 *
 *
 */
class Test5 @JvmOverloads constructor(var name: String, val age: Int = 0) {

    var learnName: String

    init {
        learnName = if (age == 0) "未上学" else "上小学"
    }

    fun getDesc(school: String): String {
        return "欢迎来到 $school: $name 现在的状况是 $learnName"
    }

}
