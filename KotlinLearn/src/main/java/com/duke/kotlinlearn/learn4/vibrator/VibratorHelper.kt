package com.duke.kotlinlearn.learn4.vibrator

import android.content.Context
import android.os.VibrationEffect
import android.os.Vibrator

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-12 18:13
 * description:
 *
 */
class VibratorHelper {

    fun vibrate(context: Context){
        val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
//        val vibe = VibrationEffect.createOneShot(300,300)
//        vibrator.vibrate(vibe)
        vibrator.vibrate(300)
    }

    val Context.vibrator:Vibrator
        get() = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

}