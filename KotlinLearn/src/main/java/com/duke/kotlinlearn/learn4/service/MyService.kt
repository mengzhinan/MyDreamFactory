package com.duke.kotlinlearn.learn4.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startService

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-12 17:12
 * description:
 *
 */
class MyService : MyInterfaceTest, Service() {

    fun startTest(){
        // import org.jetbrains.anko.intentFor
//        val intent = intentFor<MyService>()


        val intent = Intent(this@MyService, MyService::class.java)
        startService(intent)


        // implementation "org.jetbrains.anko:anko-common:$anko_version"
        // import org.jetbrains.anko.startService
        startService<MyService>()


        startService<MyService>("key" to "value")



    }

    fun startTest2(){
        val intent = intentFor<MyService>("key" to "value")
        startService(intent)
    }

    fun startTest3(){
        val intent = intentFor<MyService>(
            Pair("key","value")
        )
        startService(intent)
    }











    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

}