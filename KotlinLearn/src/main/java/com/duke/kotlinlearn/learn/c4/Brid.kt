package com.duke.kotlinlearn.learn.c4

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 13:24
 * description:
 *
 * 变量、方法、类默认都是 public，所以一般都把 public 省略
 *
 */
open class Brid(var name: String, val sex: Int = MALE) {

    var sexName: String

    init {
        sexName = getSexName(sex)
    }

    open protected fun getSexName(sex: Int): String {
        return if (sex == MALE) "公􏻻" else "母􏻼"
    }


    fun getDesc(tag: String): String {
        return "􏼜􏼝􏵺􏷄欢迎来到 $tag：这只 􏳴􏱺􏸣${name} 是 􏱼${sexName} 的。􏱶􏵵"
    }

    companion object BirdStatic {
        val MALE = 0
        val FEMALE = 1
        val UNKNOWN = -1

        fun judgeSex(sexName: String): Int {

            var sex: Int = when (sexName) {
                "公􏻻", "雄􏼥" -> MALE
                "􏻼母", "雌􏼦" -> FEMALE
                else -> UNKNOWN
            }

            return sex

        }


    }
}