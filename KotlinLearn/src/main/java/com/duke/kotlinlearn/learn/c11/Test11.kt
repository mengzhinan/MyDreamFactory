package com.duke.kotlinlearn.learn.c11

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 16:46
 * description:
 *
 */
object Test11 {

    // 条件值是 数字，必须添加 else
    fun testEnum1() {
        var counts = 3
        var str = when (counts % 4) {
            Season11.SPRING.ordinal -> Season11.SPRING.name
            Season11.SUMMER.ordinal -> Season11.SUMMER.name
            Season11.AUTUMN.ordinal -> Season11.AUTUMN.name
            Season11.WINTER.ordinal -> Season11.WINTER.name
            else -> "􏾀􏹲"
        }
    }

    // 条件值是 枚举，可以不添加 else
    fun testEnum2() {
        var season11 = Season11.SPRING
        var str = when (season11) {
            Season11.SPRING -> Season11.SPRING.name
            Season11.SUMMER -> Season11.SUMMER.name
            Season11.AUTUMN -> Season11.AUTUMN.name
            Season11.WINTER -> Season11.WINTER.name
        }
    }

    fun testSealed() {
        var count = 3
        var str = when (count % 4) {
            0 -> SeasonSealed.A("a")
            1 -> SeasonSealed.B("b")
            2 -> SeasonSealed.C("c")
            else -> SeasonSealed.D
        }
    }

}