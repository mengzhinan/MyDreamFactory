package com.duke.kotlinlearn.learn.c0

import android.util.Log

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-04 15:22
 * description:
 *
 */
class KotlinLearn1 {

    fun test() {

    }

    fun declareVar() {
        var bb: Byte = 1
        var ss: Short = 0
        var iii: Float
        val i = 1.0f
        var b: Boolean = i.isNaN()
        var c: Char = i.toChar()
        val myHelper = KotlinLearn1()
        myHelper.test()
    }

    fun declareArray() {
        var int_array: IntArray = intArrayOf(1, 2, 3)

        var int_array_2: Array<Int> = arrayOf(1, 2, 3)

        var short_arr: ShortArray = shortArrayOf(1, 2)

        var string_array: Array<String> = arrayOf("How", "Are", "You")


    }

    fun computeWhile1() {
        var int_array_2: Array<Int> = arrayOf(1, 2, 3)
        var i: Int = 0
        while (i < int_array_2.size) {
//            Log.v("testwhile","value = "+int_array_2.get(i))
            Log.v("testwhile", "value = " + int_array_2[i])
            i++
        }


    }

    fun computeWhile2() {
        var str: String = "ABCDE"

        // 获取第三个位置的字符
        var s = str.get(3)
        var s2 = str[3]


    }

    fun strConcat() {
        var str: String = "hello kotlin"

        // 变量替换
        var format: String = "输出内容：$str"
        var format2: String = "输出内容：${str.length}"

        // 输出美元符号
        var print: String = "美元符号 ${'$'}"
        var print2: String = "美元符号 \$"

    }

    fun switchCase() {
        var count: Int = 0
        val str: String
        when (count) {
            0 -> str = "􏵡􏵢􏵣􏵤􏱶􏵥􏵦􏱼"
            1 -> str = "􏵨􏵩􏵪􏵫􏱶􏵥􏵦􏱼" //if􏵃􏵄􏴔􏴕􏵭􏵣 语句可以没有 else，但是 􏱹􏵮􏱼when 语句必须带上 􏵃􏵄􏵯􏵰􏵱􏴶else
            else -> str = "􏳧􏵲􏱹􏱺􏵳􏱼􏳬􏵴􏳧􏵲"
        }
        // 不需要 break


        val str2: String = when (count) {
            0 -> "􏵡􏵢􏵣􏵤􏱶􏵥􏵦􏱼"
            1 -> "􏵨􏵩􏵪􏵫􏱶􏵥􏵦􏱼" //if􏵃􏵄􏴔􏴕􏵭􏵣 语句可以没有 else，但是 􏱹􏵮􏱼when 语句必须带上 􏵃􏵄􏵯􏵰􏵱􏴶else
            else -> "􏳧􏵲􏱹􏱺􏵳􏱼􏳬􏵴􏳧􏵲"
        }


        val str3: String = when (count) {
            1, 3, 5, 7, 9 -> "􏵡􏵢􏵣􏵤􏱶􏵥􏵦􏱼"
            in 13..19 -> "􏵨􏵩􏵪􏵫􏱶􏵥􏵦􏱼"
            !in 6..10 -> "􏵷􏱻􏱶􏵷􏱹􏵸􏵹􏳦􏵺􏵻􏵻"
            else -> "􏳧􏵲􏱹􏱺􏵳􏱼􏳬􏵴􏳧􏵲"
        }

    }

    fun isOf() {
        var str: String = ""
        // 等价 instanceof
        if (str is String) {

        }
    }

    fun isWhen() {
        var count: Int = 1;
        var countType: Number = when (count) {
            0 -> count.toLong();
            1 -> count.toDouble()
            else -> count.toFloat()
        }
        var str: String = when (countType) {
            is Long -> "􏵼􏵽􏵾􏵾􏵪􏵿􏶀"
            is Double -> "􏶁􏴶􏱶􏶂􏶃􏶄􏶅􏵒"
            else -> "􏶆􏶇􏶈􏶉􏶊􏱻􏶋"
        }
    }


    fun forWhile() {
        val poemArray: Array<String> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢")
        var poem: String = ""
        for (item in poemArray) {
            poem = "$poem$item􏱹\n"
        }
    }

    fun forWhile2() {
        val poemArray: Array<String> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢")
        var poem: String = ""

        //indices􏵏􏳳􏴐􏴑􏶣􏶤􏵒􏶥􏱶􏳭􏴘􏴐􏴑 表示数组变量对应的下标数组
        for (i in poemArray.indices) {
            if (i % 2 == 0) {
                // []
                poem = "$poem${poemArray[i]}，􏱹\n"
            } else {
                // .get()
                poem = "$poem${poemArray.get(i)}。􏵵\n"
            }
        }

    }

    fun forWhile3() {
        // 左闭右开区间，合法值包括 11，但不包括 66
        for (i in 11 until 66) {
        }

        // 每次默认递增1，这里改为递增 􏶬􏱹􏱺􏱻􏶯􏴬􏵋􏶬􏶭􏶮4
        for (i in 23..89 step 4) {
        }

        // for􏵅􏵆􏱽􏱾􏶭􏶮􏱹􏱺􏱻􏳤􏳥 循环默认递增，这里使用 downTo 表示递减􏵏􏳳􏶭􏶰
        for (i in 50 downTo 7) {
        }


    }

    fun forWhile4() {
        val poemArray: Array<String> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢")
        var poem: String = ""
        var i: Int = 0
        while (i < poemArray.size) {
            if (i % 2 == 0) {
                poem = "$poem${poemArray[i]}，􏱹\n"
            } else {
                poem = "$poem${poemArray[i]}􏵵。\n"
            }
            i++
        }
    }

    fun forWhile5() {
        val poemArray: Array<String> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢")
        var poem: String = ""
        var i: Int = 0
        do {
            if (i % 2 == 0) {
                poem = "$poem${poemArray[i]}，􏱹\n"
            } else {
                poem = "$poem${poemArray[i]}􏵵。\n"
            }
            i++
        } while (i < poemArray.size)
    }

    fun continueBreak() {
        val poemArray: Array<String?> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢", null)
        var poem: String = ""
        var pos: Int = -1
        var count: Int = 0
        while (pos <= poemArray.size) {
            pos++
            if (poemArray[pos].isNullOrBlank()) {
                // 继续当前循环的下一个节点步骤
                continue
            }

            if (count % 2 == 0) {
                poem = "$poem${poemArray[pos]}，􏱹\n"
            } else {
                poem = "$poem${poemArray[pos]}􏵵。\n"
            }
            count++
            if (count == 4) {
                break
            }
        }
    }

    fun breakAll() {
        val poemArray: Array<String> = arrayOf("A􏶒", "B􏶗", "C􏶘􏶙􏶚􏴋􏶛􏶜􏶝", "D􏶞􏶟􏶠􏴗􏶊􏶡􏶢")
        var i: Int = 0
        var is_found = false
        //􏷆􏷇􏷈􏵅􏵆􏷉􏷊􏵖􏷋 给外层循环加个名叫 outside 的标记
        outside@ while (i < poemArray.size) {
            var j: Int = 0
            var item = poemArray[i]
            while (j < item.length) {
                if (item[j] == '一') {
                    is_found = true
                    //􏶹􏶺􏷌􏷍􏱹􏷎􏷏􏷐􏵇 发现情况，直接跳出 outside 标记的循环􏵅􏵆
                    break@outside
                }
                j++
            }
            if (is_found) {
                // 跳出当前层次的循环
                break
            }
            i++
        }
    }


    fun nullableVar1() {
        var length: Int?
        var str: String? = null
        length = str?.length

    }

    fun nullableVar2() {
        var length: Int
        var str: String? = null
        length = str?.length ?: -1

    }

    fun nullableVar3() {
        var length: Int
        var str: String? = ""
        length = str!!.length

    }
}






