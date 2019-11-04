package com.duke.kotlinlearn.learn2.d3

import android.content.Context
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.alert


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-18 09:31
 * description:
 *
 */
class MyDialog : AppCompatActivity() {


    fun dialog1(context: Context) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("尊敬的用户􏳅􏳆􏱲􏱐􏳇")
        builder.setMessage("􏳈􏳉􏱲􏱀􏳊􏳋􏳌􏳍􏳎确定要卸载吗？")
        builder.setPositiveButton("继续卸载") { dialog, which ->
            {
                TODO("业务处理")
            }
        }
        builder.setNegativeButton("我再想想") { dialog, which ->
            {
                TODO("业务处理")
            }
        }
        val alert = builder.create()
        alert.show()

    }

    fun dialog2(context: Context) {
        alert("􏳈􏳉􏱲􏱀􏳊􏳋􏳌􏳍􏳎", "􏳅􏳆􏱲􏱐􏳇") {
            positiveButton("") {
                TODO("业务逻辑")
            }
            negativeButton("􏳌􏳞􏳟􏳟") {
                TODO("业务逻辑")
            }
        }.show()
    }


}