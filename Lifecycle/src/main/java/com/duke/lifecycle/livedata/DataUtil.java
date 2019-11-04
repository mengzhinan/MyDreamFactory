package com.duke.lifecycle.livedata;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:48
 * description:
 */
public class DataUtil {

    private MutableLiveData<String> name = new MutableLiveData<>();

    public LiveData<String> getNameLiveData(){
        return name;
    }

    public void requestHead() {
        // 模拟请求网络或 DB，然后更新数据
        name.setValue("requestHead success");
    }

    public void requestList() {
        // 模拟请求网络或 DB，然后更新数据
        name.setValue("requestList success");
    }

}
