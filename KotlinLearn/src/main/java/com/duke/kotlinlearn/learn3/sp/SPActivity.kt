package com.duke.kotlinlearn.learn3.sp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.duke.kotlinlearn.R


class SPActivity : AppCompatActivity() {

    // 声明字符串类型的委托属性
    private var name: String by PreferenceTool(this, "name", "")

    // 声明整数类型的委托属性
    private var age: Int by PreferenceTool(this, "age", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sp)

        // name, age 属性在声明时就从 sp 中获取到值
        // 更改 name，age 属性的值时，立即触发保存到 sp 中


    }
}
