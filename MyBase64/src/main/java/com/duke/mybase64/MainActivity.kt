package com.duke.mybase64

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.duke.mybase64.MyBase64
import com.duke.mybase64.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MyBase64.getBase64().encode(null)


    }
}
