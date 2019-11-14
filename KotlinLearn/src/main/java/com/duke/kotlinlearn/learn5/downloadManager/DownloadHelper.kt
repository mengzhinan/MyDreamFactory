package com.duke.kotlinlearn.learn5.downloadManager

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.selector

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-14 09:07
 * description:
 *
 */
class DownloadHelper : AppCompatActivity() {

    private lateinit var downloader: DownloadManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.downloader = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    }


    fun selecterDialog() {
        val list = listOf("a", "b", "c")
        selector("title text", list) { i ->
            download(list.get(i))
        }

    }

    fun download(url: String): Long {
        val request = DownloadManager.Request(Uri.parse(url))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            // 是否允许使用流量下载，等价与 DownloadManager.Request.NETWORK_WIFI
            request.setAllowedOverMetered(false)
        }
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
        // 设置保存路径
//        request.setDestinationInExternalFilesDir()
        // 指定下载和完成后在通知栏都可见
//        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        // 是否显示在系统的下载页面上
//        request.setVisibleInDownloadsUi(true)
        // ...

        return downloader.enqueue(request)
    }


    class DownloadCompleteReceiver:BroadcastReceiver(){

        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == DownloadManager.ACTION_DOWNLOAD_COMPLETE){
                // 获取下载id
                val downId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

            }
        }

    }

    class NotificationClickReceiver :BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == DownloadManager.ACTION_NOTIFICATION_CLICKED){
                // 获取下载任务的编号数组
                val downIds = intent.getLongArrayExtra(DownloadManager.EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS)

            }
        }
    }



}