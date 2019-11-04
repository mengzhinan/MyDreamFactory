package com.duke.kotlinlearn.learn.c0

import java.text.SimpleDateFormat
import java.util.*

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-05 13:52
 * description:
 * 单例对象，其实类似于 java 的 Utils 类，
 * 内部方法都是 static 的，外部可以直接调用
 */
object KotlinLearn6 {

    private const val S_DATE: String = "yyyy-MM-dd"
    private const val S_TIME: String = "HH:mm:ss"
    private const val S_TIME_DETAIL: String = "$S_TIME:SSS"
    private const val S_DATE_TIME: String = "$S_DATE $S_TIME"

    val nowDateTime: String
        get() {
            return dateTime(S_DATE_TIME)
        }


    val nowDate: String
        get() {
            return dateTime(S_DATE)
        }

    val nowTime: String
        get() {
            return dateTime(S_TIME)
        }

    val nowTimeDetail: String
        get() {
            return dateTime(S_TIME_DETAIL)
        }

    fun getFormatTime(format: String?): String {
        return dateTime(if (format.isNullOrBlank()) S_DATE_TIME else format)
    }

    private fun dateTime(format: String): String {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.format(Date())
    }
}





