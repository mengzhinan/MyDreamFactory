package com.duke.notificationlib.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.List;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-06 18:54
 * description:
 */
public class BaseNotificationManager {

//    可能会触发提醒式通知的条件示例：
//    用户的 Activity 处于全屏模式（应用使用 fullScreenIntent）。
//    通知的优先级很高，且在搭载 Android 7.1（API 级别 25）及更低版本的设备上使用铃声或振动。
//    在搭载 Android 8.0（API 级别 26）及更高版本的设备上，通知渠道的重要程度比较高。

    // 具体项目环境时，需要创建有意义的通道
    private String CHANNEL_ID = "channel_id";
    private String CHANNEL_NAME = "channel_name";

    private static NotificationManagerCompat NOTIFICATION_MANAGER_COMPAT;
    private static NotificationManager NOTIFICATION_MANAGER;
    private static BaseNotificationManager INSTANCE;
    private static Context APPLICATION_CONTEXT;

    private BaseNotificationManager(Context context) {
        NOTIFICATION_MANAGER_COMPAT = NotificationManagerCompat.from(context);
        NOTIFICATION_MANAGER = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        APPLICATION_CONTEXT = context.getApplicationContext();
    }

    public static BaseNotificationManager getInstance(@NonNull Context context) {
        if (INSTANCE == null) {
            INSTANCE = new BaseNotificationManager(context);
        }
        return INSTANCE;
    }

    /**
     * 显示通知
     */
    public void showSimple(NotificationModel notificationModel) {
        if (NOTIFICATION_MANAGER_COMPAT == null || notificationModel == null) {
            return;
        }
        Notification notification = buildNotificationSimple(notificationModel);
        if (notification == null) {
            return;
        }
        NOTIFICATION_MANAGER_COMPAT.notify(notificationModel.mNotificationId, notification);
    }

    /**
     * 显示通知
     */
    public void show(int notificationId, Notification notification) {
        if (NOTIFICATION_MANAGER_COMPAT == null || notification == null) {
            return;
        }
        NOTIFICATION_MANAGER_COMPAT.notify(notificationId, notification);
    }

    /**
     * 构建通知
     */
    private Notification buildNotificationSimple(NotificationModel notificationModel) {
        if (APPLICATION_CONTEXT == null || notificationModel == null) {
            return null;
        }

        String channelId = notificationModel.mChannelId;
        if (TextUtils.isEmpty(channelId)) {
            channelId = createNotificationChannel(CHANNEL_ID, CHANNEL_NAME);
        }
        if (channelId == null) {
            channelId = CHANNEL_ID;
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(APPLICATION_CONTEXT, channelId)
                // 每次更新进度值，再重新调用发送通知
//                .setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false);// 最大值，当前值，false 确定的进度值
//                .setProgress(0,0,false);// 可以进度完成时，再调用以删除进度条

//                .setProgress(0,0,true) // 显示无进度的进度条

//                .addAction() // 添加功能按钮
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText("Much longer text that cannot fit one line...")) // 默认通知只显示一行。设置后显示多行样式
//                .setStyle(new NotificationCompat.BigPictureStyle()
//                        .bigPicture(myBitmap)) // 大图样式
//                .setStyle(new NotificationCompat.InboxStyle()
//                        .addLine(messageSnippet1)
//                        .addLine(messageSnippet2)) // 添加多行内容的通知
//                .setGroup(GROUP_KEY_WORK_EMAIL 自定义的字符串 key) // 添加到制定组
                .setSmallIcon(notificationModel.mSmallIconResId) // 必选项，设置 logo
                .setContentTitle(notificationModel.mContentTitle)// 标题
                .setContentText(notificationModel.mContentText)// 内容
                .setPriority(notificationModel.mPriority)//生效于 should be on Android 7.1 and lower
                .setContentIntent(notificationModel.mPendingIntent) // 设置通知的点击行为 PendingIntent
                .setAutoCancel(notificationModel.mAllowAutoCancel)
                .setLargeIcon(notificationModel.mLargeIconBitmap) // 设置大图
                .setWhen(notificationModel.mWhen) // 显示同时的弹出时时间
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC) // 设置通知在锁屏时的可见性
                .setChannelId(channelId);

        return builder.build();
    }

    /**
     * 获取一个满足条件的通道 id
     *
     * @param importance example : NotificationManager.IMPORTANCE_DEFAULT
     */
    private String getExistsChannelId(int importance) {
        if (NOTIFICATION_MANAGER != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String defaultChannel = null;
            List<NotificationChannel> list = NOTIFICATION_MANAGER.getNotificationChannels();
            if (list != null && !list.isEmpty()) {
                for (NotificationChannel channel : list) {

                    // 尝试获取指定级别以上的任意通道 id

                    if (channel != null && channel.getImportance() >= importance) {
                        defaultChannel = channel.getId();
                        break;
                    }
                }
            }
            return defaultChannel;
        }
        return null;
    }

    /**
     * 创建一个普通的通道
     *
     * @param channelId   通道 id
     * @param channelName 通道名称
     * @return 返回通道名称
     */
    public String createNotificationChannelSimple(String channelId,
                                                  String channelName) {
        if (NOTIFICATION_MANAGER == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            return null;
        }
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        NOTIFICATION_MANAGER.createNotificationChannel(channel);
        return channelId;
    }

    /**
     * 创建通知渠道（重复调用误会有任何影响）
     *
     * @param channelId          通道 id
     * @param channelName        通道名称
     * @param channelDescription 通道描述
     * @param importance         example : NotificationManager.IMPORTANCE_DEFAULT
     * @return 通道名称
     */
    public String createNotificationChannel(String channelId,
                                            String channelName,
                                            String channelDescription,
                                            int importance) {
        if (NOTIFICATION_MANAGER == null) {
            return null;
        }
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel(channelId, channelName, importance);
            channel.setDescription(channelDescription);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            channel.enableVibration(true);
            channel.enableLights(true);
            channel.setLightColor(Color.BLUE);
            NOTIFICATION_MANAGER.createNotificationChannel(channel);
            return channelId;
        }
        return null;
    }

    public String createNotificationChannel(String channelId,
                                            String channelName,
                                            String channelDescription) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return createNotificationChannel(channelId,
                    channelName,
                    channelDescription,
                    NotificationManager.IMPORTANCE_DEFAULT);
        }
        return null;
    }

    public String createNotificationChannel(String channelId,
                                            String channelName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return createNotificationChannel(channelId,
                    channelName,
                    null,
                    NotificationManager.IMPORTANCE_DEFAULT);
        }
        return null;
    }

    /**
     * 取消单个通知
     */
    public void cancel(int notifiId) {
        if (NOTIFICATION_MANAGER_COMPAT == null) {
            return;
        }
        NOTIFICATION_MANAGER_COMPAT.cancel(notifiId);
    }

    /**
     * 取消全部通知
     */
    public void cancelAll() {
        if (NOTIFICATION_MANAGER_COMPAT == null) {
            return;
        }
        NOTIFICATION_MANAGER_COMPAT.cancelAll();
    }

    /**
     * 应用的系统通知开关是否打开
     */
    public boolean isNotificationEnable() {
        if (NOTIFICATION_MANAGER_COMPAT == null) {
            return false;
        }
        return NOTIFICATION_MANAGER_COMPAT.areNotificationsEnabled();
    }

    /**
     * 打开通知的设置页面
     */
    public void openNotificationSettings() {
        if (APPLICATION_CONTEXT == null
                || APPLICATION_CONTEXT.getPackageName() == null) {
            return;
        }
        String packageName = APPLICATION_CONTEXT.getPackageName();
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // android 8.0引导
            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
            intent.putExtra(Settings.EXTRA_APP_PACKAGE, packageName);
        } else {
            // 其他
            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
            intent.setData(Uri.fromParts("package", packageName, null));
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        APPLICATION_CONTEXT.startActivity(intent);
    }
}
