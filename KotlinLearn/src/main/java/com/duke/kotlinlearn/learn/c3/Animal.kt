package com.duke.kotlinlearn.learn.c3

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 11:46
 * description: 类的继承
 *
 * 开放性修饰符：
 * 1、public     对所有人开放。默认值
 * 2、internal   只对本模块内部开放
 * 3、protected  只对 自己 和 子类 开放
 * 4、private    只对 自己 开放
 *
 * open 修饰符：
 * 1、kotlin 类默认是 final 类型的，如果该类需要被继承，需要添加 open 修饰类定义
 * 2、kotlin 函数默认是 final 的，如果想被子类重写，需要添加 open 修饰函数定义
 */
open class Animal(var name: String, val sex: Int = 0) {


}