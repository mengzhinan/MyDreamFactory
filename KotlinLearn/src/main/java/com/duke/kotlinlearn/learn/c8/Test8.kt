package com.duke.kotlinlearn.learn.c8


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:06
 * description: 嵌套类测试
 *
 */
object Test8 {

    fun test() {

        // 使用嵌套类时，只能使用外部类的名称，
        // 不能使用外部类的构造函数，也不能访问外部类的成员

        // 嵌套类调用方法：
        var nestingTree = Tree.NestingTree("嵌套类测试")


    }

}