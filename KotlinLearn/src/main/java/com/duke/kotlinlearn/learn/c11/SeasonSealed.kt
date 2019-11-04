package com.duke.kotlinlearn.learn.c11

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:40
 * description: 密封类
 *
 * 密封类是一个严格的枚举类，它的值是一个有限的集合
 * 密封类内部的每个嵌套类都必须继承该外部类
 * 枚举是实例可数，密封类是子类可数
 */
sealed class SeasonSealed {

    class A(var v: String) : SeasonSealed()
    class B(var v: String) : SeasonSealed()
    class C(var v: String) : SeasonSealed()
    object D : SeasonSealed()

}
