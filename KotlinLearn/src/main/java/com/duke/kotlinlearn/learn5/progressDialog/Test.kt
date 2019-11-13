package com.duke.kotlinlearn.learn5.progressDialog

import android.app.ProgressDialog
import android.content.Context
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.progressDialog

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-13 17:14
 * description:
 *
 */
class Test {


    // 水平进度对话框
    fun dialogHorizontal1(context: Context){
        val dialog = ProgressDialog(context)
        dialog.setTitle("")
        dialog.setMessage("")
        dialog.max = 100
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL) // 水平
//        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER) // 圆形
        dialog.show()

    }

    // 水平进度对话框
    fun dialogHorizontal2(context: Context){
        val dialog = context.progressDialog("正在加载","请稍后")
        dialog.show()
    }

    // 不确定进度对话框
    fun dialogIndeterminate2(context: Context){
        val dialog = context.indeterminateProgressDialog("正在加载","请稍后")
        dialog.show()
    }

}