package com.duke.kotlinlearn.learn3.io

import java.io.File

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-01 09:56
 * description:
 *
 */
class SearchFile {
    companion object {
        fun searchFiles(filePath: String): List<File> {

            val fileList: MutableList<File> = mutableListOf()
            val fileTree: FileTreeWalk = File(filePath).walk()
            fileTree.maxDepth(1)
                    .filter { it.isFile }
                    .filter { it.extension in listOf("jpg", "png") }
                    .forEach { fileList.add(it) }
            return fileList
        }
    }
}
