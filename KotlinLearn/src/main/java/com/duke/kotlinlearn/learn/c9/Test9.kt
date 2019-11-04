package com.duke.kotlinlearn.learn.c9



/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:06
 * description: 嵌套类测试
 *
 */
object Test9 {

    fun test() {

        // 在嵌套类前面添加关键字 inner 后，就变成类内部类
        // 内部类可以访问外部类的成员
        // 调用内部类时，要先实力话外部类，即调用外部类的构造函数

        // 内部类调用方法：
        var innerTree = Tree9("外部类测试").NestingTree9("内部类测试")


    }

}