package com.duke.kotlinlearn.learn2.d2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.duke.kotlinlearn.Kotlin1Activity
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.jetbrains.anko.startActivityForResult


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-17 10:09
 * description:
 *
 */
class JumpActivity2 : AppCompatActivity() {

    /**
     * 1、使用 intentFor 获取 intent 对象
     * 2、使用 newTask() 设置 FLAG_ACTIVITY_NEW_TASK 启动模式
     */
    fun jump1() {
        var intent = intentFor<Kotlin1Activity>(
                "request_time" to 126451321234,
                "request_content" to "hello world")
//        startActivity(intent)
        startActivity(intent.newTask())

    }

    // =============================================

    fun jumpForResult() {
        val people = People("无名", 123)
        startActivityForResult<Kotlin1Activity>(0, "people" to people)

    }

    fun jumpForResultReturn() {
        val people = People("无名", 123)
        val intent = Intent()
        intent.putExtra("people", people)
        setResult(Activity.RESULT_OK, intent)
        finish()

    }

    fun jumpForResultReturnParse(){
        val response = intent.extras?.getParcelable<People>("people")
    }

}

