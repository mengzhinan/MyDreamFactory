package com.duke.kotlinlearn.learn5.http

import android.location.Location
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL
import java.text.MessageFormat

/**
 * @Author: duke
 * @DateTime: 2019-11-12 22:28
 * @Description:
 *
 */
class Test {


    private val mapsUrl = "http://maps.google.cn/maps/api/geocode/json?latlng={0},{1}&sensor=true&language=zh-CN"


    // 位置监听器侦听到定位变化事件，就调用接口获取详细信息
    private fun setLocationText(location: Location?){
        if (location == null){
            return
        }
        doAsync {
            val url = MessageFormat.format(mapsUrl, location.latitude, location.longitude)
            // readText 获取网络请求文本数据
            // readBytes 获取网络请求二进制字节数据
            val text = URL(url).readText()
            uiThread {
                // 刷新数据 text
            }
        }
    }




}