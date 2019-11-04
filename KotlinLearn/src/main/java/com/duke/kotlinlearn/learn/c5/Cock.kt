package com.duke.kotlinlearn.learn.c5

import com.duke.kotlinlearn.learn.c4.Brid


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 13:57
 * description: 抽象类的实现类
 *
 */
class Cock(name: String = "公鸡", sex: Int = Brid.MALE, voice: String = "哈哈") :
    Chicken(name, sex, voice) {

    override fun callOut(times: Int): String {
        // when 语句判断大于和小于时，要把完整的判断区域写到每个分支中
        var count = when {
            times <= 0 -> 0
            times >= 10 -> 9
            else -> times
        }
        return "$count"
    }


}