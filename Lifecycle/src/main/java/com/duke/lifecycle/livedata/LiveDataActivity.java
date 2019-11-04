package com.duke.lifecycle.livedata;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:46
 * description:
 */
public class LiveDataActivity extends AppCompatActivity {

    private DataUtil dataUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataUtil = new DataUtil();
        dataUtil.getNameLiveData().observe(this, data -> {
            // 得到数据更新



        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataUtil.requestHead();
        dataUtil.requestList();
    }
}
