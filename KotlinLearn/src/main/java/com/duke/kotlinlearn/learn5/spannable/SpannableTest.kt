package com.duke.kotlinlearn.learn5.spannable

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.Spanned
import android.text.style.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.underline
import org.jetbrains.anko.*

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-15 13:47
 * description:
 *
 */
class SpannableTest : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    fun spannable1() {

        val str: Spanned = buildSpanned {
            append("为", StyleSpan(Typeface.BOLD))
            append("人民", RelativeSizeSpan(1.5F))
            append("服务", ForegroundColorSpan(Color.RED))
            append("是谁", BackgroundColorSpan(Color.GREEN))
            append("提出来的", UnderlineSpan())
        }

    }

    fun spannable2() {

        val str: Spanned = buildSpanned {
            append("为", Bold)
            append("人民", RelativeSizeSpan(1.5F))
            append("服务", foregroundColor(Color.RED))
            append("是谁", backgroundColor(Color.GREEN))
            append("提出来的", Underline)
        }

    }


}