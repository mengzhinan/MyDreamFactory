package com.duke.kotlinlearn.learn.c6

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 14:56
 * description: 接口实现类
 *
 *
 * java 的 extends 和 implement，在 kotlin 中都被替换为了 ：
 * 接口和抽象类都在 ： 后面，多个之间以逗号分隔
 *
 */
class TBehaviorImpl : TBehavior {
    override fun fly(): String {
        return "fly"
    }

    override fun swim(): String {
        return "swim"
    }

    // 父类已经实现了该方法，实现类可以不重写。可选
    override fun run(): String {
        return super.run()
    }

    override var skilledSports: String = "游泳"


}