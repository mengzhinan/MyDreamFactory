package com.duke.kotlinlearn.learn.c10

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:22
 * description: 带构造函数 的 枚举类
 *
 * 可以访问枚举值和顺序 id
 * SeasonType.XXX.ordinal
 * SeasonType.XXX.name
 * SeasonName.XXX.seasonName
 *
 */
enum class Season2(val seasonName: String) {

    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")


}