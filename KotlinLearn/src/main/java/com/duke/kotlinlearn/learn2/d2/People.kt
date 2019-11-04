package com.duke.kotlinlearn.learn2.d2

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-09-16 17:27
 * description: 要使用 @Parcelize 注解，注意事项：
 * 1、依赖：implementation "org.jetbrains.kotlin:kotlin-android-extensions-runtime:$kotlin_version"
 * 2、build.gradle 配置：
 *
 *
 *
 * apply plugin: 'kotlin-android-extensions'
 * apply plugin: 'kotlin-android'
 *
 * android {
 *     。。。
 *     androidExtensions {
 *         experimental = true
 *     }
 *     。。。
 * }
 *
 */
@Parcelize
@SuppressLint("ParcelCreator")
data class People(val name: String, val age: Int) : Parcelable


