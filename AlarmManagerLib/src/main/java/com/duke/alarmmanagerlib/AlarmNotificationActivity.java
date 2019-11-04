package com.duke.alarmmanagerlib;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.duke.alarmmanagerlib.alarm.AlarmBroadcastReceiver;
import com.duke.alarmmanagerlib.alarm.AlarmModel;
import com.duke.alarmmanagerlib.alarm.BaseAlarmManager;

import java.util.Calendar;

public class AlarmNotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LOG_TAG = "alarm_notifi_test";
    private TextView mAlarm1View;
    private TextView mAlarm2View;
    private TimePicker mTimePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_notification);
        mAlarm1View = findViewById(R.id.alarm1);
        mAlarm2View = findViewById(R.id.alarm2);
        mTimePicker = findViewById(R.id.timepicker);
        mAlarm1View.setOnClickListener(this);
        mAlarm2View.setOnClickListener(this);
        mTimePicker.setIs24HourView(true);
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                updateTime(hourOfDay, minute);
            }
        });
        updateTime(0, 0);
    }

    private void updateTime(int hourOfDay, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        if (hourOfDay != 0) {
            calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        }
        if (minute != 0) {
            calendar.set(Calendar.MINUTE, minute);
        }
        mTimePicker.setTag(calendar.getTimeInMillis());
    }

    @Override
    public void onClick(View v) {
        long targetTime;
        try {
            targetTime = Long.parseLong(mTimePicker.getTag().toString());
        } catch (Exception e) {
            targetTime = System.currentTimeMillis() + 3000;
        }
        if (v.getId() == R.id.alarm1) {

            Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
            intent.setAction(AlarmBroadcastReceiver.INTENT_TOPIC_ALARM_RECEIVE_ACTION);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmModel alarmModel = new AlarmModel();
            alarmModel.mAlarmManagerType = AlarmManager.RTC_WAKEUP;
            alarmModel.mTimeStart = targetTime;
            alarmModel.mPendingIntent = pendingIntent;
            BaseAlarmManager.getInstance(this).setOnceAlarmCompat(alarmModel);

            Toast.makeText(this, "alarm1 success", Toast.LENGTH_SHORT).show();
            Log.v(LOG_TAG, "alarm1 success");

        } else if (v.getId() == R.id.alarm2) {

            Intent intent = new Intent(this, AlarmBroadcastReceiver.class);
            intent.setAction(AlarmBroadcastReceiver.INTENT_TOPIC_ALARM_RECEIVE_ACTION);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT);

            AlarmModel alarmModel = new AlarmModel();
            alarmModel.mAlarmManagerType = AlarmManager.RTC_WAKEUP;
            alarmModel.mTimeStart = targetTime + 5 * 1000;
            alarmModel.mPendingIntent = pendingIntent;

            BaseAlarmManager.getInstance(this).setOnceAlarmCompat(alarmModel);

            Toast.makeText(this, "alarm2 success", Toast.LENGTH_SHORT).show();
            Log.v(LOG_TAG, "alarm2 success");

        }
    }
}
