package com.duke.kotlinlearn.learn2.d2

import android.app.Activity
import android.content.Intent
import com.duke.kotlinlearn.Kotlin1Activity
import org.jetbrains.anko.startActivity

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-16 16:51
 * description:
 *
 */
class JumpActivity1 : Activity() {

    /**
     * 页面跳转：
     * 1、注意 this@
     * 2、注意::class.java
     */
    fun jumpActivity1() {
        val intent = Intent(this@JumpActivity1, Kotlin1Activity::class.java)
        this@JumpActivity1.startActivity(intent)
    }

    /**
     * 跳转2：
     * 1、需要导入：org.jetbrains.anko.startActivity
     * 2、build.gradle 中导入："org.jetbrains.anko:anko-common:$anko_version"
     */
    fun jumpActivity2() {
        this@JumpActivity1.startActivity<Kotlin1Activity>()
    }

    /**
     * 跳转3：
     * 1、参数名与参数值使用关键字 to 隔开
     */
    fun jumpActivity3(){
        startActivity<Kotlin1Activity>(
                "参数名1" to "参数值1",
                "参数名2" to "参数值2")
    }

    /**
     * 跳转4：
     * 1、使用 Pair
     */
    fun jumpActivity4(){
        startActivity<Kotlin1Activity>(
                Pair("参数名1" , "参数值1"),
                Pair("参数名2" , "参数值2"))
    }

    /**
     * 下一个页面解析参数
     */
    fun paramParse(){
        val bundle = intent.extras
        val param1 = bundle?.getString("参数名1")
        val param2 = bundle?.getString("参数名2")


    }


    // =传递序列化对象====================================================

    fun jumpActivityParcelable(){
        val people = People("机器人",12)
        startActivity<Kotlin1Activity>("学生1" to people)
    }

    fun parseParcelable(){
        val people = intent.extras?.getParcelable<People>("学生1")

    }





}