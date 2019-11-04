package com.duke.kotlinlearn.learn.c9

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:00
 * description: 内部类
 *
 *
 *
 */
class Tree9(var treeName: String) {

    inner class NestingTree9(var nestingTreeName: String) {

        fun getNestingName(): String {

            return "外部类名称 $treeName - 内部类名称 $nestingTreeName"
        }

    }


}