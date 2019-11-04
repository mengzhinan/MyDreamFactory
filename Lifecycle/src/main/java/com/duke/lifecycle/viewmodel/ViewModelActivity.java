package com.duke.lifecycle.viewmodel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:47
 * description:
 */
public class ViewModelActivity extends AppCompatActivity {

    private ListViewModel listViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        listViewModel.getHeadLiveData().observe(this, data->{
            // 头部数据更新

        });
        listViewModel.getListLiveData().observe(this, data->{
            // list 数据更新

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listViewModel.requestHead();
        listViewModel.requestList();
    }
}
