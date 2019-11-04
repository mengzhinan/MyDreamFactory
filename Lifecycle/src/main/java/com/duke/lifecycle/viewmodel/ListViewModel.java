package com.duke.lifecycle.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-29 16:48
 * description:
 */
public class ListViewModel extends ViewModel {
    private MutableLiveData<String> headLiveData;
    private MutableLiveData<String> listLiveData;

    public LiveData<String> getHeadLiveData() {
        if (headLiveData == null) {
            headLiveData = new MutableLiveData<>();
        }
        return headLiveData;
    }

    public LiveData<String> getListLiveData() {
        if (listLiveData == null) {
            listLiveData = new MutableLiveData<>();
        }
        return listLiveData;
    }

    public void requestHead() {
        // TODO: 2019-07-29
        headLiveData.setValue("head request success");
    }

    public void requestList() {
        // TODO: 2019-07-29
        listLiveData.setValue("list request success");
    }
}
