package com.duke.mydreamfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duke.tablayoutlib.TabActivity
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        startActivity(intentFor<TabActivity>())

    }
}
