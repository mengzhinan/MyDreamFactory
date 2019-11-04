package com.duke.kotlinlearn.learn.c8

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:00
 * description: 嵌套类 NestingTree
 *
 * 1、普通的嵌套类不能访问外部类成员，如 treeName
 *
 */
class Tree(var treeName: String) {

    class NestingTree(var nestingTreeName: String) {

        fun getNestingName(): String {

            return "嵌套类名称 $nestingTreeName"
        }

    }


}