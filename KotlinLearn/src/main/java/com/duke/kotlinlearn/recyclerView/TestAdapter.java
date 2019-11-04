package com.duke.kotlinlearn.recyclerView;


import androidx.collection.ArrayMap;

import com.duke.kotlinlearn.R;
import com.duke.kotlinlearn.recyclerView.adapter.BaseNewAdapter;
import com.duke.kotlinlearn.recyclerView.holder.TestLeftHolder;
import com.duke.kotlinlearn.recyclerView.holder.TestRightHolder;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-11-01 16:15
 * description:
 */
public class TestAdapter extends BaseNewAdapter {

    // VIEW_TYPE 系统默认值为 0
    private static final int VIEW_TYPE_LEFT = 1;
    private static final int VIEW_TYPE_RIGHT = 2;
//    private static final int VIEW_TYPE_OTHER = 3;

    @Override
    protected ArrayMap<Integer, ViewType> onCreateViewTypes() {
        ArrayMap<Integer, ViewType> viewTypeMap = new ArrayMap<>();
        viewTypeMap.put(VIEW_TYPE_LEFT, new BaseNewAdapter.ViewType(R.layout.recycler_item_left, TestLeftHolder.class));
        viewTypeMap.put(VIEW_TYPE_RIGHT, new BaseNewAdapter.ViewType(R.layout.recycler_item_right, TestRightHolder.class));
        return viewTypeMap;
    }

    public static BaseNewAdapter.RecyclerItem<String> createLeftItem(String item) {
        return new BaseNewAdapter.RecyclerItem<>(VIEW_TYPE_LEFT, item);
    }

    public static BaseNewAdapter.RecyclerItem<String> createRightItem(String item) {
        return new BaseNewAdapter.RecyclerItem<>(VIEW_TYPE_RIGHT, item);
    }
}
