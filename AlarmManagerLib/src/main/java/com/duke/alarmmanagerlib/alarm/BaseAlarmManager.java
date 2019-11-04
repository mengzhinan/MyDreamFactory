package com.duke.alarmmanagerlib.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

import androidx.core.app.AlarmManagerCompat;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-06 17:42
 * description:
 */
public class BaseAlarmManager {

    //= 一次性 ==========================================
    // set() //用于设置一次性闹铃，执行时间在设置时间附近，为非精确闹铃

    // setExact() //用于设置一次性闹铃，执行时间更为精准，为精确闹铃
    // setAlarmClock() //与 setExact() 类似，同时闹钟类型为 RTC_WAKEUP

    // setAndAllowWhileIdle() //设置一次性闹钟，可以在低功耗模式下运行
    // setExactAndAllowWhileIdle() //与 setAndAllowWhileIdle() 类似，但是执行时间更为精准

    // setWindow() //用于设置某个时间段内的一次闹铃。比如，我想在下午的2点到4点之间设置一次提醒。


    //= 重复性 ==========================================
    // setInexactRepeating() //设置重复闹铃
    // setRepeating() //设置重复闹铃，比 setInexactRepeating() 略微准确。但是在 4.4 之后，这个也不够准确


    private static AlarmManager ALARM_MANAGER;
    private static BaseAlarmManager INSTANCE;

    private BaseAlarmManager(Context context) {
        ALARM_MANAGER = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    public static BaseAlarmManager getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new BaseAlarmManager(context);
        }
        return INSTANCE;
    }

    /**
     * 设置一次性闹钟
     *
     * @param alarmModel  闹钟数据
     * @param isEconomize 是否使用省电模式，即闹钟不是很准时，跟随系统电量优化
     */
    public void setOnceAlarmCompat(AlarmModel alarmModel, boolean isEconomize) {
        if (ALARM_MANAGER == null || alarmModel == null) {
            return;
        }
        // 注意 AlarmManagerCompat.setExactAndAllowWhileIdle()
        if (isEconomize) {
            AlarmManagerCompat.setAndAllowWhileIdle(ALARM_MANAGER, alarmModel.mAlarmManagerType, alarmModel.mTimeStart, alarmModel.mPendingIntent);
        } else {
            AlarmManagerCompat.setExactAndAllowWhileIdle(ALARM_MANAGER, alarmModel.mAlarmManagerType, alarmModel.mTimeStart, alarmModel.mPendingIntent);
        }
    }

    public void setOnceAlarmCompat(AlarmModel alarmModel) {
        setOnceAlarmCompat(alarmModel, false);
    }

    /**
     * 设置重复闹钟
     *
     * @param alarmModel  闹钟数据
     * @param isEconomize 是否使用省电模式，即闹钟不是很准时，跟随系统电量优化
     */
    public void setRepeatingAlarmCompat(AlarmModel alarmModel, boolean isEconomize) {
        if (ALARM_MANAGER == null || alarmModel == null) {
            return;
        }
        if (isEconomize) {
            ALARM_MANAGER.setInexactRepeating(alarmModel.mAlarmManagerType, alarmModel.mTimeStart, alarmModel.mTimeBetween, alarmModel.mPendingIntent);
        } else {
            ALARM_MANAGER.setRepeating(alarmModel.mAlarmManagerType, alarmModel.mTimeStart, alarmModel.mTimeBetween, alarmModel.mPendingIntent);
        }
    }

    public void setRepeatingAlarmCompat(AlarmModel alarmModel) {
        setRepeatingAlarmCompat(alarmModel, false);
    }

    public void cancelAlarmNotify(PendingIntent pendingIntent) {
        if (ALARM_MANAGER == null || pendingIntent == null) {
            return;
        }
        ALARM_MANAGER.cancel(pendingIntent);
    }

}
