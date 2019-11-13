package com.duke.kotlinlearn.learn5.json

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-13 18:26
 * description:
 *
 */
data class UserInfo(
    var name: String = "",
    var age: Int = 0,
    var height: Long = 0L,
    var weight: Float = 0F,
    var married: Boolean = false
) {


}