package com.duke.kotlinlearn.learn.c2

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 伴生对象 -> 对应弥补 java 的 static 静态特性
 *
 * 类似 静态方法
 * 在类加载时就运行伴生对象的代码块，其作用相当于 java 的 static { ... }
 * 关键字 companion 表示伴随，object 表示对象
 * 下例 CompanionTest6 表示伴生对象名称
 *
 */
class Test6 @JvmOverloads constructor(var name: String, val age: Int = 0) {

    var learnName: String

    init {
        learnName = if (age == 0) "未上学" else "上小学"
    }

    fun getDesc(school: String): String {
        return "欢迎来到 $school: $name 现在的状况是 $learnName"
    }


    // 在类加载时就运行伴生对象的代码块，其作用相当于 java 的 static { ... }
    // 关键字 companion 表示伴随，object 表示对象
    // 下例 CompanionTest6 表示伴生对象名称
    companion object CompanionTest6 {

        fun judgeAge(learnN: String): Int {
            return if ("未上学" == learnN) 0 else 1
        }

    }


    fun test() {
        // 外部调用伴生对象，形同 java 的静态方法
        // 伴生对象名称可以省略
        var age = Test6.judgeAge("未上学")

        var age2 = Test6.CompanionTest6.judgeAge("上小学")


    }


}
