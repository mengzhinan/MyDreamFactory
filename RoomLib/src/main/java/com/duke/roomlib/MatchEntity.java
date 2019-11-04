package com.duke.roomlib;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-15 17:44
 * description: Room Entity
 */
@Entity(tableName = "topic_match_table",
        primaryKeys = {"topic_id", "match_id"},
        indices = {
                @Index(value = {"topic_id"}),
                @Index(value = {"topic_id", "match_id"})
        })
@Keep
public class MatchEntity implements Parcelable {

    public MatchEntity() {

    }

    @Ignore
    public MatchEntity(int matchId) {
        this.mMatchId = matchId;
    }

    @Ignore
    public MatchEntity(String topicId, int matchId, String teamA, String teamB, long timeStart) {
        this.mTopicId = topicId;
        this.mMatchId = matchId;
        this.mTeamA = teamA;
        this.mTeamB = teamB;
        this.mTimeStart = timeStart;
    }

    // 话题 id
    @ColumnInfo(name = "topic_id")
    @NonNull
    public String mTopicId;

    // 赛事 id
    @ColumnInfo(name = "match_id")
    @NonNull
    public int mMatchId;

    // 赛队 A
    @ColumnInfo(name = "team_a")
    public String mTeamA;

    // 赛队 B
    @ColumnInfo(name = "team_b")
    public String mTeamB;

    // 闹钟开始时间
    @ColumnInfo(name = "time_start")
    public long mTimeStart;

    @Ignore
    public PendingIntent mPendingIntent;

    // 参考 AlarmManager.RTC_WAKEUP
    // ELAPSED 开头的代表系统运行逝去的时间，RTC 开头的是世界时钟
    // 以WAKEUP结尾的类型能够唤醒设备
    // public static final int RTC_WAKEUP = 0;
    // public static final int RTC = 1;
    // public static final int ELAPSED_REALTIME_WAKEUP = 2;
    // public static final int ELAPSED_REALTIME = 3;
    // 闹钟类型
    @Ignore
    public int mAlarmManagerType = AlarmManager.RTC_WAKEUP;


    @Override
    public String toString() {
        String name = MatchEntity.class.getCanonicalName();
        if (name == null) {
            return super.toString();
        }

        String timeString = SimpleDateFormat.getDateTimeInstance().format(new Date(mTimeStart));
        return name + " -> mTopicId = " +
                mTopicId +
                " mMatchId = " +
                mMatchId +
                " mTeamA = " +
                mTeamA +
                " mTeamB = " +
                mTeamB +
                " mTimeStart = " +
                timeString;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTopicId);
        dest.writeInt(this.mMatchId);
        dest.writeString(this.mTeamA);
        dest.writeString(this.mTeamB);
        dest.writeLong(this.mTimeStart);
        dest.writeParcelable(this.mPendingIntent, flags);
        dest.writeInt(this.mAlarmManagerType);
    }

    protected MatchEntity(Parcel in) {
        this.mTopicId = in.readString();
        this.mMatchId = in.readInt();
        this.mTeamA = in.readString();
        this.mTeamB = in.readString();
        this.mTimeStart = in.readLong();
        this.mPendingIntent = in.readParcelable(PendingIntent.class.getClassLoader());
        this.mAlarmManagerType = in.readInt();
    }

    public static final Parcelable.Creator<MatchEntity> CREATOR = new Parcelable.Creator<MatchEntity>() {
        @Override
        public MatchEntity createFromParcel(Parcel source) {
            return new MatchEntity(source);
        }

        @Override
        public MatchEntity[] newArray(int size) {
            return new MatchEntity[size];
        }
    };
}
