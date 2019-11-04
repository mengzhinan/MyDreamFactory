package com.duke.kotlinlearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duke.kotlinlearn.learn.c0.KotlinLearn1
import com.duke.kotlinlearn.learn.c0.KotlinLearn2
import com.duke.kotlinlearn.recyclerView.TestNewAdapterActivity
import org.jetbrains.anko.startActivity

class Kotlin1Activity : AppCompatActivity() {

    var helper: KotlinLearn1? = null
    var learn2: KotlinLearn2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin1)

//        helper?.computeWhile1()
//
//        button1.text = "AB"
//
//        button1.setOnClickListener {
//            button1.text = "点击了"
//            toast("kotlin toast")
//        }
//
//        button1.setOnLongClickListener { button1.text = "􏳩􏳮􏳯􏳫􏳬􏳰􏳱"; true }
//

//        learn2 = KotlinLearn2()
//
//        KotlinLearn5().extraMethodCall()
//        var a = Animal()

//        var animal41 = Animal4(this, "animal41")
//        var animal42 = Animal4(this, "animal41","北京")


//        Test7.test()

        this@Kotlin1Activity.startActivity<TestNewAdapterActivity>()


    }


}



