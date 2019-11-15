package com.duke.kotlinlearn.learn5.apk

import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-15 14:16
 * description:
 *
 */
class Test : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    private fun getApkPath(packageName: String, versionName: String): String {
        var local_path = ""
        val cursor = contentResolver.query(
            MediaStore.Files.getContentUri("external"),
            null,
            "mime_type=\"application/vnd.android.package-archive\"",
            null,
            null
        ) ?: return local_path
        while (cursor.moveToNext()) {
            // title 获取文件名，data 获取文件完整路径，size 获取文件大小
            val path = cursor.getString(cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA))

            // 从 apk 文件中解析得到该安装包的程序信息
            val pi = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES)
            if (pi != null) {

                // 找到包名与版本号都符合的 apk 文件
                if (pi.packageName == packageName && pi.versionName == versionName) {
                    local_path = path
                }
            }
        }
        cursor.close()
        return local_path
    }

}