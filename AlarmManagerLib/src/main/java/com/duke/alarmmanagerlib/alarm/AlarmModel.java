package com.duke.alarmmanagerlib.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-08 09:34
 * description:
 */
public class AlarmModel {

    // 参考 AlarmManager.RTC_WAKEUP
    // ELAPSED 开头的代表系统运行逝去的时间，RTC 开头的是世界时钟
    // 以WAKEUP结尾的类型能够唤醒设备
    // public static final int RTC_WAKEUP = 0;
    // public static final int RTC = 1;
    // public static final int ELAPSED_REALTIME_WAKEUP = 2;
    // public static final int ELAPSED_REALTIME = 3;
    // 闹钟类型
    public int mAlarmManagerType = AlarmManager.RTC_WAKEUP;

    // 闹钟开始时间
    public long mTimeStart;

    // 重复闹钟的间隔时间
    public long mTimeBetween;

    public PendingIntent mPendingIntent;

}
