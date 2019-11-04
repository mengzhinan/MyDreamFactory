package com.duke.roomlib;


import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java8.util.stream.StreamSupport;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-08-16 10:12
 * description:
 */
public class MatchViewModel extends AndroidViewModel {

    private MutableLiveData<List<MatchEntity>> matchListLiveData;
    private MutableLiveData<Boolean> setupNotifyLiveData;
    private MutableLiveData<Boolean> cancelNotifyLiveData;


    public MatchViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        matchListLiveData = null;
        setupNotifyLiveData = null;
        cancelNotifyLiveData = null;
    }

    public static MatchViewModel get(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(MatchViewModel.class);
    }

    public MutableLiveData<List<MatchEntity>> getMatchListLiveData() {
        if (matchListLiveData == null) {
            matchListLiveData = new MutableLiveData<>();
        }
        return matchListLiveData;
    }

    public MutableLiveData<Boolean> getSetupNotifyLiveData() {
        if (setupNotifyLiveData == null) {
            setupNotifyLiveData = new MutableLiveData<>();
        }
        return setupNotifyLiveData;
    }

    public MutableLiveData<Boolean> getCancelNotifyLiveData() {
        if (cancelNotifyLiveData == null) {
            cancelNotifyLiveData = new MutableLiveData<>();
        }
        return cancelNotifyLiveData;
    }

    /**
     * 获取所有已经开启的赛事提醒数据 id array (提供给前端)
     */
    @SuppressLint("CheckResult")
    public String[] getTopicMatchesId(String topicId) {
        if (TextUtils.isEmpty(topicId)) {
            return new String[0];
        }
        // int[] to String[]
        int[] idsIntArray = MatchRoomHelper.getInstance(getApplication()).getTopicMatchesId(topicId);
        if (idsIntArray == null || idsIntArray.length == 0) {
            return new String[0];
        }
        String[] idsStringArray = new String[idsIntArray.length];
        for (int i = 0; i < idsIntArray.length; i++) {
            idsStringArray[i] = String.valueOf(idsIntArray[i]);
        }
        return idsStringArray;
    }

    /**
     * app 启动时，初始化赛事提醒数据：
     * 1、删除过期数据
     * 2、对有效的数据，重新设置闹钟
     */
    @SuppressLint("CheckResult")
    public void initMatchData() {
        Observable.create((ObservableOnSubscribe<List<MatchEntity>>) e -> e.onNext(MatchRoomHelper.getInstance(getApplication()).getAllMatches()))
                .subscribeOn(Schedulers.io())
                .subscribe(matchEntities -> {
                            if (matchEntities == null || matchEntities.size() == 0) {
                                return;
                            }

                            long currentTime = System.currentTimeMillis();

                            // 找出过期的提醒，批量删除过期数据
                            StreamSupport.stream(matchEntities)
                                    .filter(entity -> entity.mTimeStart <= currentTime)
                                    .forEach(matchEntity -> {
                                        // 批量删除过期数据
                                        MatchRoomHelper.getInstance(getApplication()).deleteMatch(matchEntity);
                                    });

                            // 找出仍然有效的提醒，重新设置闹钟
                            StreamSupport.stream(matchEntities)
                                    .filter(entity -> entity.mTimeStart > currentTime)
                                    .forEach(matchEntity -> {
                                        // 重新设置闹钟
//                                        MatchAlarmHelper.setAlarm(getApplication(), matchEntity);
                                    });
                        },
                        throwable -> {
                        });
    }

    /**
     * 设置提醒数据记录，设置闹钟
     */
    @SuppressLint("CheckResult")
    public void setupMatchAlarm(MatchEntity... matchEntities) {
//        if (matchEntities == null || matchEntities.length == 0) {
//            return;
//        }
//        Observable.create((ObservableOnSubscribe<Boolean>) e -> {
//            boolean isSuccess;
//            try {
//                MatchRoomHelper.getInstance(getApplication()).insertMatch(matchEntities);
//                for (MatchEntity matchEntity : matchEntities) {
////                    MatchAlarmHelper.setAlarm(getApplication(), matchEntity);
//                }
//                isSuccess = true;
//            } catch (Exception error) {
//                isSuccess = false;
//            }
//            e.onNext(isSuccess);
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result -> {
//                    getSetupNotifyLiveData().postValue(true);
//                    // toast 提示成功
//                    Toast.makeText(getApplication(), getApplication().getString(R.string.topic_match_time_alarm_success_toast), Toast.LENGTH_SHORT).show();
//                }, throwable -> getSetupNotifyLiveData().postValue(false));
    }

    /**
     * 取消提醒数据记录，取消闹钟
     */
    @SuppressLint("CheckResult")
    public void cancelMatchAlarm(MatchEntity... matchEntities) {
        if (matchEntities == null || matchEntities.length == 0) {
            return;
        }
        Observable.create((ObservableOnSubscribe<Boolean>) e -> {
            boolean isSuccess;
            try {
                MatchRoomHelper.getInstance(getApplication()).deleteMatch(matchEntities);
                for (MatchEntity matchEntity : matchEntities) {
//                    MatchAlarmHelper.cancelAlarm(getApplication(), matchEntity);
                }
                isSuccess = true;
            } catch (Exception error) {
                isSuccess = false;
            }
            e.onNext(isSuccess);
        })
                .subscribeOn(Schedulers.io())
                .subscribe(result -> getCancelNotifyLiveData().postValue(true),
                        throwable -> getCancelNotifyLiveData().postValue(false));
    }

}
