package com.duke.kotlinlearn.learn.c7

import android.util.Log


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 15:46
 * description:
 *
 */
object Test7 {

    fun test() {

        var manWear = ManWear()
        var womanWear = WomanWear()

        Log.v("testby", "${WearAgent(manWear).wear()}")
        Log.v("testby", "${WearAgent(womanWear).wear()}")

    }

}