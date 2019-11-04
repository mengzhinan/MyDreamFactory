package com.duke.kotlinlearn.learn.c2

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 静态方法
 *
 *  在伴生对象中增加常量，如果 java 的静态常量
 *
 */
class Test7 @JvmOverloads constructor(var name: String, val age: Int = NO_LEARN) {

    var learnName: String

    init {
        learnName = if (age == NO_LEARN) "未上学" else "上小学"
    }

    fun getDesc(school: String): String {
        return "欢迎来到 $school: $name 现在的状况是 $learnName"
    }


    // 在伴生对象中增加常量，如果 java 的静态常量
    companion object CompanionTest6 {

        val HAS_LEARN = 1
        val NO_LEARN = 0

        fun judgeAge(learnN: String): Int {
            return when (learnN) {
                "未上学" -> NO_LEARN
                "上小学" -> HAS_LEARN
                else -> NO_LEARN
            }
        }

    }


    fun test() {
        // 外部调用伴生对象常量，类似 java 的静态常量
        var age = Test7.HAS_LEARN


    }


}
