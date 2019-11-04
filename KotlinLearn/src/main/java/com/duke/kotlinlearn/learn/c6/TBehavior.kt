package com.duke.kotlinlearn.learn.c6

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 14:35
 * description: 接口
 *
 * 注意：
 * 1、接口不能定义构造函数
 * 2、接口内的方法默认是抽象的，即 abstract open。实现类需要重写这些抽象方法
 * 3、kotlin 允许接口内实现某个抽象方法
 * 4、接口内的所有方法默认都是 open 的，包括实现的方法
 *
 */
interface TBehavior {

    // 接口中 open abstract 都可以不加

    open abstract fun fly(): String

    fun swim(): String


    fun run(): String {
        return "􏹷􏼿􏴐􏶂􏶃􏽃􏸙􏴯􏶜􏻎􏸰􏱹􏸣􏵣􏼺􏶂􏹎􏽄􏽅􏸭􏵸􏴐􏶂􏸗􏸦􏽆􏳮􏽇􏽃􏵵小鸟奔跑"
    }


    // 抽象属性，实现类必须重写
    // 省略了 abstract open 关键字
    var skilledSports: String
}