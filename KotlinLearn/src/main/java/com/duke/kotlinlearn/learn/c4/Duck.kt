package com.duke.kotlinlearn.learn.c4

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 13:23
 * description:
 *
 */
class Duck(name: String = "鸭子􏼸􏹈", sex: Int = MALE) : Brid(name, sex) {

    /**
     * protected 的方法重写后，默认就是 protected 的。
     * 重写后，可以升级范围为 public，但是不能降为 private
     */
    public override fun getSexName(sex: Int): String {
        return "${super.getSexName(sex)} - o"
    }

    fun test() {

        // 调用方法
        var duck = Duck(sex = MALE)

    }

}