package com.duke.kotlinlearn.learn.c5

import com.duke.kotlinlearn.learn.c4.Brid

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 13:52
 * description: 抽象类
 *
 */
abstract class Chicken(name: String, sex: Int, var voice: String) : Brid(name, sex) {


    val numberArray: Array<String> = arrayOf("一􏳬", "二􏵬", "三􏺎", "四􏹶", "五􏼱", "六􏼲", "七􏺔", "八􏼳", "九􏼴", "十􏼵")

    // 抽象方法必须在子类重写
    // abstract 方法默认是 open 的，故省略 open 关键字
    abstract fun callOut(times: Int): String

}