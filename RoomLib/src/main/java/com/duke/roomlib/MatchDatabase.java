package com.duke.roomlib;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-15 17:44
 * description: Room Database
 */
@Database(entities = {MatchEntity.class}, version = MatchDatabase.DB_VERSION, exportSchema = false)
public abstract class MatchDatabase extends RoomDatabase {

    // you need update this version value when you update database structure
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "topic_match.db";

    public abstract MatchDao getMatchDao();

}
