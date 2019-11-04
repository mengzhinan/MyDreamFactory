package com.duke.kotlinlearn.adapter;


/**
 * author: duke
 * version: 1.0
 * dateTime: 2019-07-10 17:39
 * description: 活跃回答者
 */
public class BaseActiveAnswererViewFactory {

    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_NO_CREATION = 2;
    public static final int TYPE_HAS_CREATION = 3;
    public static final int TYPE_PROGRESS = 4;
    public static final int TYPE_END_TIP = 5;


    public static class CreateViewType {

//        public static BaseRecyclerViewAdapter.ViewType createNormal() {
//            return new BaseRecyclerViewAdapter.ViewType(TYPE_NORMAL,
//                    R.layout.list_item,
//                    NormalViewHolder.class);
//        }

    }

    public static class CreateRecyclerItem {

//        public static BaseRecyclerViewAdapter.RecyclerItem<Object> createNormalItem(Object item) {
//            return new BaseRecyclerViewAdapter.RecyclerItem<>(BaseActiveAnswererViewFactory.TYPE_NORMAL, item);
//        }

    }
}
