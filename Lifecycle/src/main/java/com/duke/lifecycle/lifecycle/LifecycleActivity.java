package com.duke.lifecycle.lifecycle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:46
 * description:
 */
public class LifecycleActivity extends AppCompatActivity {
    private MyEventBus myEventBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myEventBus = new MyEventBus();
        getLifecycle().addObserver(myEventBus);


    }
}
