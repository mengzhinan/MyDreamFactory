package com.duke.kotlinlearn.learn5.contentProvider

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.database.ContentObserver
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.telephony.SmsManager
import androidx.appcompat.app.AppCompatActivity

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-15 11:33
 * description:
 *
 */
class ContentObserverActivity : AppCompatActivity() {

    private val SENT_SMS_ACTION = "com.test.kotlin.SENT_SMS_ACTION"
    private val DELIVERED_SMS_ACTION = "com.test.kotlin.DELIVERED_SMS_ACTION"


    private val uri = Uri.parse("content://sms")

    private lateinit var mObserver: SmsGetObserver
    private val handler = Handler()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mObserver = SmsGetObserver(this, handler)
        contentResolver.registerContentObserver(uri, true, mObserver)
    }

    override fun onDestroy() {
        contentResolver.unregisterContentObserver(mObserver)
        super.onDestroy()
    }


    fun sendSmsAuto(number: String, message: String) {

        // 短信发送广播意图
        val sentIntent = Intent(SENT_SMS_ACTION)
        sentIntent.putExtra("number", number)
        sentIntent.putExtra("message", message)
        val sentPI = PendingIntent.getBroadcast(
            this, 0, sentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 短信接收广播意图
        val deliveredIntent = Intent(DELIVERED_SMS_ACTION)
        deliveredIntent.putExtra("number", number)
        deliveredIntent.putExtra("message", message)
        val deliveredPI = PendingIntent.getBroadcast(
            this, 1, deliveredIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // 发送短信需要权限
        val smsManager = SmsManager.getDefault()
        smsManager.sendTextMessage(number, null, message, sentPI, deliveredPI)

    }


    // 定义一个短信观察器的嵌套类
    private inner class SmsGetObserver(
        private var mContext: Context,
        handler: Handler
    ) : ContentObserver(handler) {

        override fun onChange(selfChange: Boolean) {
            var sender = ""
            var content = ""
            // 查询收件箱中来自某运营商的最近短信
            val selection =
                "address='10005' and date > ${System.currentTimeMillis() - 1000L * 60 * 60}"
            val columns = arrayOf("address", "body", "date")
            val cursor = mContext.contentResolver.query(
                uri!!, columns, selection, null, " date desc"
            )
            while (cursor.moveToNext()) {
                sender = cursor.getString(0)
                content = cursor.getString(1)
                break
            }
            cursor.close()
            super.onChange(selfChange)
        }

    }


}
