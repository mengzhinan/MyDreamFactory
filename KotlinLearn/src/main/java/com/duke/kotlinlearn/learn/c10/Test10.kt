package com.duke.kotlinlearn.learn.c10

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 17:08
 * description:
 *
 */
object Test10 {

    fun test(season2: Season2) {
        var str = when (season2) {
            Season2.AUTUMN -> Season2.AUTUMN.seasonName
            Season2.SPRING -> Season2.SPRING.seasonName
            Season2.SUMMER -> Season2.SUMMER.seasonName
            Season2.WINTER -> Season2.WINTER.seasonName
        }
    }

}
