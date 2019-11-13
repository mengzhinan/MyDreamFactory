package com.duke.kotlinlearn.learn5.async

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.uiThread

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-13 17:54
 * description: 异步任务 与 UI 交互
 * doAsync    uiThread
 */
class AsyncThreadActivity : AppCompatActivity() {

    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loadData()

    }

    fun loadData() {
        dialog = indeterminateProgressDialog("加载数据", "正在加载")

        // 异步任务
        doAsync {
            // for 循环模拟下载数据
            for (i in 0..100) {
                Thread.sleep(200)
                uiThread {
                    refreshUI()
                }
            }
            uiThread {
                // completed
            }
        }
    }

    fun refreshUI() {
        if (dialog.isShowing) dialog.dismiss()
    }

}