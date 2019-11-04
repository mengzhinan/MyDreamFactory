package com.duke.kotlinlearn.learn3.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duke.kotlinlearn.R


class DBActivity : AppCompatActivity() {

    var helper: UserDBHelper = UserDBHelper.getInstance(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)


    }
}
