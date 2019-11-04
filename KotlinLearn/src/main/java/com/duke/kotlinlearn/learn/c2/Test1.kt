package com.duke.kotlinlearn.learn.c2

import android.content.Context
import org.jetbrains.anko.toast

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-06 18:29
 * description: 带默认参数的主构造函数，兼容 java 代码
 * 添加注解 @JvmOverloads，使 java 代码也能识别默认参数
 * 因为添加了注解标记，所以主构造函数必须补上关键字 constructor
 */
class Test1 @JvmOverloads constructor(context: Context, name: String, age:Int = 0){

    init {
        context.toast("name = $name , age = $age")
    }







}
