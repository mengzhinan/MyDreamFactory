package com.duke.alarmmanagerlib.alarm;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.duke.alarmmanagerlib.NotificationOpenActivity;
import com.duke.alarmmanagerlib.R;
import com.duke.notificationlib.notify.BaseNotificationManager;
import com.duke.notificationlib.notify.NotificationModel;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-06 18:23
 * description:
 */
public class AlarmBroadcastReceiver extends BroadcastReceiver {
    //    private boolean isRegistered;
    public static final String INTENT_TOPIC_ALARM_RECEIVE_ACTION = "intent_topic_alarm_receive_action";

    // 如果作为闹钟广播，必须在清单文件静态注册
//    public void register(Context context) {
//        if (context == null || isRegistered) {
//            return;
//        }
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(INTENT_TOPIC_ALARM_RECEIVE_ACTION);
//        context.registerReceiver(this, intentFilter);
//        isRegistered = true;
//    }
//
//    public void unRegister(Context context) {
//        if (context == null || !isRegistered) {
//            return;
//        }
//        context.unregisterReceiver(this);
//        isRegistered = false;
//    }


    @Override
    public void onReceive(Context context, Intent intent) {
        Log.v("alarmtest","onReceive()");
        String action = null;
        if (context == null
                || intent == null
                || intent.getAction() == null
                || !(action = intent.getAction()).startsWith(INTENT_TOPIC_ALARM_RECEIVE_ACTION)) {
            return;
        }

        // TODO: 2019-08-08 demo

        int id = (int) System.currentTimeMillis();
        Intent newIntent = new Intent(context, NotificationOpenActivity.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                id, newIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.mAllowAutoCancel = true;
        notificationModel.mContentText = "测试内容";
        notificationModel.mContentTitle = "测试标题";
        notificationModel.mSmallIconResId = R.mipmap.ic_launcher;
        notificationModel.mNotificationId = id;
        notificationModel.mPendingIntent = pendingIntent;
        BaseNotificationManager.getInstance(context).showSimple(notificationModel);
    }

//    private void 前端设置或取消提醒(){
//        // 1、更改 UI
//
//        // 2、请求网络 (设置提醒、取消提醒的请求接口，由前端调用更合理)
//        boolean 提醒状态更改 = true;//设置或取消提醒是否成功
//        if (提醒状态更改){
//            // 成功
//
//            // 端能力调用 Android 入口方法，设置本地闹钟
//
//        }else{
//            // 忽略
//        }
//    }
//
//    // 需要此操作的原因：Android 本地闹钟是与 App 进程绑定的，
//    // 如果 App 人为或被系统杀死，则之前设置的所有闹钟全部失效。
//    private void Android启动App重新设置闹钟(){
//
//        // 1、需要请求接口，获取当前用户设置过提醒的赛事信息列表
//
//        // 2、判断状态和时间，对有效的状态重新设置本地闹钟
//    }

}
