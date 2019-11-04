package com.duke.lifecycle.lifecycle;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:47
 * description:
 */
public class MyEventBus implements LifecycleObserver {

    public static void register(){

    }

    public static void unRegister(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        register();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        unRegister();
    }

}
