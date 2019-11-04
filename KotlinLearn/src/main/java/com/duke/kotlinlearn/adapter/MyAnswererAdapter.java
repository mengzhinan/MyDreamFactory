package com.duke.kotlinlearn.adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-10 17:42
 * description:
 */
public class MyAnswererAdapter extends BaseRecyclerViewAdapter {
    @Override
    protected List<ViewType> onCreateViewTypes() {
        List<ViewType> viewTypes = new ArrayList<>();
//        viewTypes.add(BaseActiveAnswererViewFactory.CreateViewType.createNormal());
//        viewTypes.add(BaseActiveAnswererViewFactory.CreateViewType.createNoCreation());
        return viewTypes;
    }
}
