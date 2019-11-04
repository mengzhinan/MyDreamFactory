package com.duke.notificationlib.notify;

import android.app.PendingIntent;
import android.graphics.Bitmap;

import androidx.core.app.NotificationCompat;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-07 10:18
 * description:
 * https://developer.android.google.cn/guide/topics/ui/notifiers/notifications
 */
public class NotificationModel {

    // 通知的 channelId。Android 8.0 以上版本为必选项
    public String mChannelId;

    // 每个通知的唯一 id
    // Remember to save the notification ID that you pass to
    // NotificationManagerCompat.notify() because you'll need it later
    // if you want to update or remove the notification.
    public int mNotificationId;

    // （必选）通知左上角 icon
    // 小图标：必须提供，通过 setSmallIcon() 进行设置。
    public int mSmallIconResId;

    // （可选）通知右侧大图
    // 大图标：可选内容（通常仅用于联系人照片，请勿将其用于应用图标），通过 setLargeIcon() 进行设置。
    public Bitmap mLargeIconBitmap;

    // （可选）同时显示时的时间
    // 时间戳：由系统提供，但您可以通过 setWhen() 将其替换掉或者通过 setShowWhen(false) 将其隐藏。
    public long mWhen;

    // （可选）
    // 标题：可选内容，通过 setContentTitle() 进行设置。
    public String mContentTitle;

    // （可选）
    // 文本：可选内容，通过 setContentText() 进行设置。
    public String mContentText;

    // 在搭载 Android 8.0（API 级别 26）及更高版本的设备上，
    // 通知的重要程度由通知发布到的渠道的 importance 决定。
    // 用户可以在系统设置中更改通知渠道的重要程度（图 12）。
    // 在搭载 Android 7.1（API 级别 25）及更低版本的设备上，
    // 每条通知的重要程度均由通知的 priority 决定。
    //
    // 可能的重要程度等级如下所示：
    // 紧急：发出提示音，并以提醒式通知的形式显示。
    // 高：发出提示音。
    // 中：无提示音。
    // 低：无提示音，且不会在状态栏中显示。
    public int mPriority = NotificationCompat.PRIORITY_DEFAULT;

    // 是否允许，当用户点击通知后，移除当前通知
    public boolean mAllowAutoCancel = true;


    public PendingIntent mPendingIntent;
}
