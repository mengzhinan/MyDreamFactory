package com.duke.roomlib;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-15 17:44
 * description: Room Dao
 */
@Dao
public interface MatchDao {

    @Query("SELECT match_id FROM topic_match_table WHERE topic_id = :topicId")
    int[] getTopicMatchesId(String topicId);

    @Query("SELECT * FROM topic_match_table")
    List<MatchEntity> getAllMatches();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMatch(MatchEntity... matchEntities);

    @Delete
    void deleteMatch(MatchEntity... matchEntities);

    @Query("DELETE FROM topic_match_table WHERE topic_id = :topicId AND match_id = :matchId")
    void deleteMatchById(String topicId, int matchId);
}
