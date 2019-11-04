package com.duke.kotlinlearn.learn.c12

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-09 18:26
 * description: 数据类 - java 的实体类
 *
 * 1、数据类必须有主构造函数，且至少有一个输入参数
 * 2、要声明与输入参数同名的属性，即输入参数前面添加关键字 var 或 val
 * 3、数据类不能是基类、子类、抽象类、内部类、密封类等，即独立的类
 * 4、数据类自带 copy 克隆方法
 * 5、copy(title="新标题") 克隆方法带参数，修改指定的值
 * 6、数据类自带 equlas 方法，判断两个对象是否一样
 * 7、数据类自带 toString 方法
 *
 */
data class MessageObject(var id: Int, var title: String, var content: String, var time: Long) {



}