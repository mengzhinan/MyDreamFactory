package com.duke.roomlib;

import android.content.Context;

import androidx.room.Room;

import java.util.List;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-15 17:44
 * description:
 */
public class MatchRoomHelper {

    private static MatchDatabase MATCH_DATABASE;
    private static MatchRoomHelper INSTANCE;

    private MatchRoomHelper(Context applicationContext) {
        MATCH_DATABASE = Room.databaseBuilder(applicationContext, MatchDatabase.class, MatchDatabase.DB_NAME)
                .allowMainThreadQueries() // 允许在主线程执行数据库操作
                .build();
    }

    public synchronized static MatchRoomHelper getInstance(Context applicationContext) {
        if (INSTANCE == null) {
            INSTANCE = new MatchRoomHelper(applicationContext);
        }
        return INSTANCE;
    }

    public List<MatchEntity> getAllMatches() {
        return MATCH_DATABASE.getMatchDao().getAllMatches();
    }

    public int[] getTopicMatchesId(String topicId) {
        return MATCH_DATABASE.getMatchDao().getTopicMatchesId(topicId);
    }

    public synchronized void insertMatch(MatchEntity... matchEntities) {
        MATCH_DATABASE.getMatchDao().insertMatch(matchEntities);
    }

    public synchronized void deleteMatch(MatchEntity... matchEntities) {
        MATCH_DATABASE.getMatchDao().deleteMatch(matchEntities);
    }

}
