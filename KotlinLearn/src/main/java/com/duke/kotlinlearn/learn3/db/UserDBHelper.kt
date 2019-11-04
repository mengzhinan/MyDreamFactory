package com.duke.kotlinlearn.learn3.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import org.jetbrains.anko.db.ManagedSQLiteOpenHelper

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-10-31 10:18
 * description:
 *
 * use{} 语句快，就是先打开数据库，再操作，最后 finally 中关闭数据库
 *
 */
class UserDBHelper(var context: Context, private var DB_VERSION: Int = CURRENT_VERSION)
    : ManagedSQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private val TAG = "UserDBHelper"
        var DB_NAME = "user.db"
        var TABLE_NAME = "user_info"
        var CURRENT_VERSION = 1
        private var instance: UserDBHelper? = null

        @Synchronized
        fun getInstance(context: Context, version: Int = 0): UserDBHelper {
            if (instance == null) {
                instance = if (version > 0) UserDBHelper(context.applicationContext, version)
                else UserDBHelper(context.applicationContext)
            }
            return instance!!
        }

    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d(TAG, "onCreate")
        val dropSql = "DROP TABLE IF EXISTS $TABLE_NAME;"
        Log.d(TAG, "drop_sql : $dropSql")
        db?.execSQL(dropSql)
        val createSql = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "name VARCHAR NOT NULL," +
                "age INTEGER NOT NULL," +
                "height LONG NOT NULL," +
                "weight FLOAT NOT NULL," +
                "married INTEGER NOT NULL," +
                "update_time VARCHAR NOT NULL," +
                "phone VARCHAR," +
                "password VARCHAR );"
        db?.execSQL(createSql)
        Log.d(TAG, "createSql :$createSql")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) {
            var alterSql = "ALTER TABLE $TABLE_NAME ADD COLUMN PHONE VARCHAR;"
            db?.execSQL(alterSql)
        }
    }

    // 删除符合条件的记录
    fun delete(condition: String): Int {
        var count = 0
        use {
            count = delete(TABLE_NAME, condition, null)
        }
        return count
    }

    // 添加一条记录
    fun insert(info: UserInfo): Long {
        val infoArray = mutableListOf(info)
        return insert(infoArray)
    }

    // 添加多条记录
    fun insert(infoArray: MutableList<UserInfo>): Long {
        var result: Long = -1
        for (i in infoArray.indices) {
            val info = infoArray[i]
            var tempArray: List<UserInfo>
            // 如果存在同名记录，就更新记录
            // 注意条件语句的等号后面要用单引号括起来
            if (info.name.isNotEmpty()) {
                val condition = "name='${info.name}'"
                tempArray = query(condition)
                if (tempArray.size > 0) {
                    update(info, condition)
                    result = tempArray[0].rowId;
                    continue
                }
            }
            // 若不存在唯一性重复的记录，则插入更新
            val cv = ContentValues()
            cv.put("name", info.name)
            use {
                result = insert(TABLE_NAME, "", cv)
            }
            // 添加成功后，返回行号，失败返回 -1
            if (result == -1L) {
                return result
            }
        }
        return result
    }


    // 更新符合条件的记录
    @JvmOverloads
    fun update(info: UserInfo, condition: String = "rowId=${info.rowId}"): Int {
        val cv = ContentValues()
        cv.put("name", info.name)
        var count = 0
        use {
            count = update(TABLE_NAME, cv, condition, null)
        }
        return count
    }

    // 查询符合条件的记录
    fun query(condition: String): List<UserInfo> {
        val sql = "select rowId,name from $TABLE_NAME where $condition;"
        var infoArray = mutableListOf<UserInfo>()
        use {
            val cursor = rawQuery(sql, null)
            if (cursor.moveToFirst()) {
                while (true) {
                    val info = UserInfo()
                    info.name = cursor.getString(1)
                    info.rowId = cursor.getLong(0)
                    infoArray.add(info)
                    if (cursor.isLast) {
                        break
                    }
                    cursor.moveToNext()
                }
            }
            cursor.close()
        }
        return infoArray
    }


    // 根据 id 查询用户记录
    fun queryById(id: Long): UserInfo {
        val infoArray = query("rowId = '$id'")
        return if (infoArray.isNotEmpty()) infoArray[0] else UserInfo()
    }

    // 删除所有记录
    fun deleteAll(): Int = delete("1=1")


    // 查询所有记录
    fun queryAll(): List<UserInfo> = query("1=1")

}
